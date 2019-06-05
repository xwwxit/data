package com.example.demo.service;

import com.example.demo.entity.DemoUser;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * created by zhangtao on 2019/5/22
 */

public interface DemoUserService {

     List<Map<String,Object>> getUserInfo();

     DemoUser getMessageById(String id);


     PageInfo<List<Map<String,Object>>> getPageUserInfo();


}
