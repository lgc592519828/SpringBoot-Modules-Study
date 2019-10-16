package cn.gcheng.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 主库配置文件
 * @author gcheng.L
 * @create 2019-10-10 17:56
 */
@Configuration
@MapperScan(basePackages = {"cn.gcheng.springboot.mapper.master"}, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourcesConfig extends DataSourceConfig{

    /**
     * 获取配置文件中数据库配置属性， 属性常量配置在父类中
     */
    @Value("${spring.datasource.druid.master.url}")
    private String url;

    @Value("${spring.datasource.druid.master.username}")
    private String username;

    @Value("${spring.datasource.druid.master.password}")
    private String password;


    /**
     * 注册 master 数据源, @Primary标志这个 Bean 如果在多个同类 Bean 候选时，该 Bean 优先被考虑。
     * @return
     */
    @Primary
    @Bean("masterDataSource")
    public DataSource masterDataSourceBean() {
        DruidDataSource ds = getDataSourceProperties();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        try {
            ds.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }

    /**
     * 注册 master 事务管理器
     * 用来开启开启主库的事务@Transactional(rollbackFor = Exception.class,value = "masterTransactionManager") value 可以省略
     * @return
     */
    @Primary
    @Bean(name = "masterTransactionManager")
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSourceBean());
    }

    @Primary
    @Bean(name = "masterSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCAL));
        return sessionFactoryBean.getObject();
    }

}
