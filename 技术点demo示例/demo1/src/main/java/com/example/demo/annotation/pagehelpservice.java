package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * created by zhangtao on 2019/5/23
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface pagehelpservice {
    /**
     * 分页注解service层
     */
}
