package com.example.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**

* @Description:    普通类获取bean实例

* @Author:         zhangtao

* @CreateDate:     2019/6/8 10:58

* @Version:        1.0

*/
@Slf4j
@Component
public class SpringUtilGetBean implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtilGetBean.applicationContext ==null){
            SpringUtilGetBean.applicationContext = applicationContext;
        }
        log.info("---------------->>>SpringUtilGetBean<<<<--------------");
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
    //通过name获取Bean
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }
    //通过class获取Bean
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }
    //通过name，以及clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> tClass){
        return getApplicationContext().getBean(name,tClass);
    }
}
