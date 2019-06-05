package com.example.demo.common;

/**  定义各种返回状态码
 * created by zhangtao on 2019/5/17
 */
public class ResultCodeConstant {

    //返回成功
    public static final Integer SUCCESS_CODE = 200;
    public static final String  SUCCESS_DESC = "成功";

    //返回失败
    public static final  Integer FAIL_CODE = -1;
    public  static final String  FAIL_DESC = "失败";

    //系统内部出错
    public static final  Integer FAIL_SYS_CODE = 500;
    public  static final String  FAIL_SYS_DESC = "系统内部错误";



}
