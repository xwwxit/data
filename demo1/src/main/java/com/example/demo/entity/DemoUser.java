package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * created by zhangtao on 2019/5/22
 */
@Data
public class DemoUser {
    //用户ID
    @Getter
    @Setter
    private String id;
    //姓名
    @Getter
    @Setter
    private String username;
    //年龄
    @Getter
    @Setter
    private String age;
    //生日
    @Getter
    @Setter
    private Date birthday;
    //标签
    @Getter
    @Setter
    private String  tags;
}
