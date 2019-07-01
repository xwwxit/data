package com.example.demo.mapper;

import com.example.demo.entity.DemoUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * created by zhangtao on 2019/5/22
 */
public interface DemoUserMapper {

    List<Map<String,Object>> getUserInfo();

    DemoUser getMessageById(String id);

    void saveDemoUserByJson(@Param("user") DemoUser user);

    List<Map<String,Object>> getEmpInfo();
}
