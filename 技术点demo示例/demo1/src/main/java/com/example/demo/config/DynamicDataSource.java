package com.example.demo.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**

* @Description:    动态数据源

* @Author:         zhangtao

* @CreateDate:     2019/6/11 9:34

* @Version:        1.0

*/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("DynamicDataSource数据源选择:" + DataSourceContextHolder.getDataSource());
        return DataSourceContextHolder.getDataSource();
    }

}
