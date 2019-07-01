package com.example.demo.config;

import com.example.demo.annotation.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**

* @Description:    多数据源，切面处理类，处理带有注解的方法类

* @Author:         zhangtao

* @CreateDate:     2019/6/11 9:49

* @Version:        1.0

*/
@Slf4j
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    @Pointcut("@annotation(com.example.demo.annotation.DataSource)")
    public void dataSourcePointCut(){
        log.info("来了老弟");
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource dataSource = method.getAnnotation(DataSource.class);
        if(dataSource == null){
            DataSourceContextHolder.setDataSource(DataSourceNames.mysql);
            log.info("set dataSource is "+DataSourceNames.mysql);
        }else{
            DataSourceContextHolder.setDataSource(dataSource.name());
            log.info("set dataSource is "+dataSource.name());
        }
        try {
            return point.proceed();
        } finally {
            DataSourceContextHolder.clearDataSource();
            log.info("clean dataSource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
