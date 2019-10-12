package cn.gcheng.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;

/**
 * 数据源配置基类
 * @author gcheng.L
 * @create 2019-10-11 16:34
 */

public class DataSourceConfig {

    /**
     * 表示mapper.xml 映射地址，这一在配置文件中配置不同的位置
     */
    @Value("${mybatis.mapper-locations}")
    protected final String MAPPER_LOCAL = null;

    @Value("${spring.datasource.druid.db-type}")
    protected String dbType;

    @Value("${spring.datasource.druid.initialSize}")
    protected int initialSize;

    @Value("${spring.datasource.druid.min-idle}")
    protected int minIdle;

    @Value("${spring.datasource.druid.max-active}")
    protected int maxActive;

    @Value("${spring.datasource.druid.max-wait}")
    protected int maxWait;

    @Value("${spring.datasource.druid.time-between-eviction-runs-millis}")
    protected int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.druid.min-evictable-idle-time-millis}")
    protected int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.validation-query}")
    protected String validationQuery;

    @Value("${spring.datasource.druid.test-while-idle}")
    protected boolean testWhileIdle;

    @Value("${spring.datasource.druid.test-on-borrow}")
    protected boolean testOnBorrow;

    @Value("${spring.datasource.druid.test-on-return}")
    protected boolean testOnReturn;

    @Value("${spring.datasource.druid.pool-prepared-statements}")
    protected boolean poolPreparedStatements;

    @Value("${spring.datasource.druid.filters}")
    protected String filters;

    @Value("${spring.datasource.druid.use-global-data-source-stat}")
    protected boolean useGlobalDataSourceStat;

    @Value("${spring.datasource.druid.driver-class-name}")
    protected String driverClassName;

    protected DruidDataSource getDataSourceProperties() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setDbType(dbType);
        ds.setInitialSize(initialSize);
        ds.setMinIdle(minIdle);
        ds.setMaxActive(maxActive);
        ds.setMaxWait(maxWait);
        ds.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunsMillis);
        ds.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        ds.setValidationQuery(validationQuery);
        ds.setTestWhileIdle(testWhileIdle);
        ds.setTestOnBorrow(testOnBorrow);
        ds.setTestOnReturn(testOnReturn);
        ds.setPoolPreparedStatements(poolPreparedStatements);
        ds.setUseGlobalDataSourceStat(useGlobalDataSourceStat);

        return ds;
    }
}
