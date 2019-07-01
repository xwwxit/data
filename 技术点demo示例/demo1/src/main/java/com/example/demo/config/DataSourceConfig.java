package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**

* @Description:    多数据源配置类

* @Author:         zhangtao

* @CreateDate:     2019/6/10 23:09

* @Version:        1.0

*/
@Configuration
public class DataSourceConfig {

    //数据源1

    @Bean(name = "datasource1")
    @ConfigurationProperties(prefix = "spring.datasource.druid.mysql")
    public DataSource mysqlDataSource(){
        return DataSourceBuilder.create().build();
    }
    //数据源2
    @Bean(name = "datasource2")
    @ConfigurationProperties(prefix = "spring.datasource.druid.oracle")
    public DataSource oracleDataSource(){
        return DataSourceBuilder.create().build();
    }

    //配置动态数据源，通过aop切换数据源
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(mysqlDataSource());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap();
        dsMap.put("datasource1", mysqlDataSource());
        dsMap.put("datasource2", oracleDataSource());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }
    /**
     * 配置注解事物
    @Transactional
    @return */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
