package com.example.demo.config;

public class DataSourceContextHolder {
    /**
     * 注意：数据源标识保存在线程变量中，避免多线程操作数据源时互相干扰
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDataSource(String dataSource){
        contextHolder.set(dataSource);
    }
    public static String getDataSource(){
        return contextHolder.get();
    }
    public static void clearDataSource(){
        contextHolder.remove();
    }
}
