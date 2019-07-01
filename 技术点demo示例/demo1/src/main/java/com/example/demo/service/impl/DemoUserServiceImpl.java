package com.example.demo.service.impl;

import com.example.demo.annotation.DataSource;
import com.example.demo.annotation.pagehelpservice;
import com.example.demo.common.DescribeException;
import com.example.demo.common.ResultCodeConstant;
import com.example.demo.entity.DemoUser;
import com.example.demo.mapper.DemoUserMapper;
import com.example.demo.service.DemoUserService;
import com.example.demo.utils.PageBean;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * created by zhangtao on 2019/5/22
 */
@Service
public class DemoUserServiceImpl implements DemoUserService {

    @Autowired
    private DemoUserMapper demoUserMapper;


    @DataSource(name = "mysql")
    @Override
    public List<Map<String,Object>> getUserInfo() {
        return demoUserMapper.getUserInfo();
    }

    @Override
    public DemoUser getMessageById(String id) {
        return demoUserMapper.getMessageById(id);
    }

    @Override
    @pagehelpservice
    public PageInfo<List<Map<String,Object>>> getPageUserInfo(){
        return new PageInfo(demoUserMapper.getUserInfo());
    }


    @DataSource(name = "oracle")
    @Override
    public List<Map<String, Object>> getEmpInfo() {
        return  demoUserMapper.getEmpInfo();
    }

    @Transactional
    @DataSource(name = "mysql")
    @Override
    public int saveUser(DemoUser demoUser) {
        int res = demoUserMapper.saveDemoUserByJson(demoUser);
        int i = 1/0;
        return res;
    }
}
