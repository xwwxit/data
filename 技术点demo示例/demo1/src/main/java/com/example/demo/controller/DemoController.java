package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.pagehelpcontroller;
import com.example.demo.common.DescribeException;
import com.example.demo.common.ExceptionEnum;
import com.example.demo.common.ResultBean;
import com.example.demo.common.ResultCodeConstant;
import com.example.demo.entity.DemoUser;
import com.example.demo.service.DemoUserService;
import com.example.demo.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zhangtao
 * @Description: 代码质量示例demo
 * @Param:
 * @Return:
 * @Create: 2019/5/22 9:50
 * @version v1.0
 */
@Slf4j
@RestController
@RequestMapping
public class DemoController {

    @Autowired
    private DemoUserService demoUserService;

    /**
     * 普通请求实例
     * @return
     */
    @GetMapping(value = "/getMessage")
    @ResponseBody
    public ResultBean getDemoUserList(){

        return new ResultBean(demoUserService.getUserInfo());
    }

    /**
     * 分页请求实例
     * @return 返回所有用户数据
     * @param currentPage 当前页数
     * @param pageSize 分页大小
     */
    @pagehelpcontroller
    @GetMapping(value ="/getMessageList")
    @ResponseBody
    public ResultBean getDemoUser(@RequestParam(value = "currentPage") int currentPage,@RequestParam(value = "pageSize") int pageSize){
        try{
            //int i = 1/0;
            log.info("hhahahahh");
        }catch (Exception e){
            throw new DescribeException(e.getMessage(), ResultCodeConstant.FAIL_SYS_CODE);
        }
        return new ResultBean(demoUserService.getPageUserInfo());
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    @ResponseBody
    public ResultBean getDemoUserById(@PathVariable String id){
        return  new ResultBean(demoUserService.getMessageById(id));
    }

    /**
     * 获取oracle中的数据
     * @return
     */
    @GetMapping("/getEmpInfo")
    @ResponseBody
    public ResultBean getEmpInfoTest(){
        return new ResultBean(demoUserService.getEmpInfo());
    }

    /**
     *
     * 插入数据到mysql中的demoUser表
     */
    @PostMapping("/saveUser")
    @ResponseBody
    public ResultBean saveDemoUser(@RequestBody String params){
        JSONObject jsonObject = JSON.parseObject(params);
        DemoUser demoUser = new DemoUser();
        demoUser.setAge(jsonObject.getString("age"));
        demoUser.setBirthday(DateUtil.stringToDate(jsonObject.getString("birthday"),"yyyy-MM-dd"));
        demoUser.setUsername(jsonObject.getString("username"));
        demoUser.setId(jsonObject.getString("id"));
        demoUser.setTags(jsonObject.getString("tags"));
        return new ResultBean(demoUserService.saveUser(demoUser));
    }
}

