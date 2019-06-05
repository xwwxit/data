package com.example.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**  异常处理
 * created by zhangtao on 2019/5/17
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBean exceptionGet(Exception e){
        if(e instanceof DescribeException){//是否属于自定义异常
            DescribeException MyException = (DescribeException) e;
            return ResultBean.error(MyException.getCode(),MyException.getMessage());
        }
        log.error("【系统异常】{}",e);
        return ResultBean.error(ExceptionEnum.UNKNOW_ERROR);
    }
}
