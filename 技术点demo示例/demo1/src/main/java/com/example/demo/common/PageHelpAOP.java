

package com.example.demo.common;

import com.example.demo.utils.PageBean;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.*;
import org.apache.ibatis.javassist.bytecode.AttributeInfo;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Aspect
@Slf4j
public class PageHelpAOP {

    //使用线程本地变量
    private static final ThreadLocal<PageBean> pageBeanContext = new ThreadLocal<>();

    //Service层切点
    @Pointcut("@annotation(com.example.demo.annotation.pagehelpservice)")
    public void serviceAspect() {
    }

    //Controller层切点
    @Pointcut("@annotation(com.example.demo.annotation.pagehelpcontroller)")
    public void controllerAspect() {
    }

    //拦截controller自定义注解
    @Before("controllerAspect()")
    public void controllerAop(JoinPoint joinPoint) throws Exception {
        log.info("Controller正在执行PageHelperAop");
        PageBean pageBean = new PageBean();
        //获取类名
        String clazzName = joinPoint.getTarget().getClass().getName();
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取方法的参数的名称
        String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        //获取方法的参数值
        Object[] args = joinPoint.getArgs();
        int i=0;
        for(String parameterName:parameterNames){
            if(parameterName.equals("currentPage")){
                pageBean.setCurrentPage((int)args[i]);
            }
            if(parameterName.equals("pageSize")){
                pageBean.setPageSize((int)args[i]);
            }
            i++;
        }
        //将分页参数放置线程变量中
        pageBeanContext.set(pageBean);
    }

    //拦截自定义注解
    @Before("serviceAspect()")
    public void serviceImplAop(){
        log.info("Service正在执行PageHelperAop");
        PageBean pageBean = pageBeanContext.get();
        PageHelper.startPage(pageBean.getCurrentPage(), pageBean.getPageSize());
    }
}
