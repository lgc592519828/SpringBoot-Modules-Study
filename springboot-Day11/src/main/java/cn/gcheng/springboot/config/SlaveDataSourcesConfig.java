package cn.gcheng.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author gcheng.L
 * @create 2019-10-10 18:10
 */
@Configuration
@MapperScan(basePackages = {"cn.gcheng.springboot.mapper.slave"}, sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class SlaveDataSourcesConfig extends DataSourceConfig{

    /**
     * 获取配置文件中数据库配置属性， 属性常量配置在父类中
     */
    @Value("${spring.datasource.druid.slave.url}")
    private String url;

    @Value("${spring.datasource.druid.slave.username}")
    private String username;

    @Value("${spring.datasource.druid.slave.password}")
    private String password;

    /**
     * 注册 slave 数据源
     * @return
     */
    @Bean("slaveDataSource")
    public DataSource slaveDataSourceBean() {
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
     * 注册 slave 事务管理器\
     * 用来开启开启主库的事务@Transactional(rollbackFor = Exception.class,value = "slaveTransactionManager"),不同的是value 不可以省略
     * @return
     */
    @Bean(name = "slaveTransactionManager")
    public DataSourceTransactionManager slaveTransactionManager() {
        return new DataSourceTransactionManager(slaveDataSourceBean());
    }

    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCAL));
        return sessionFactoryBean.getObject();
    }
}
