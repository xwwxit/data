package com.example.demo.common;

import java.io.Serializable;

/**
 * @Author zhangtao
 * @Description: 统一返回公共体
 * @Param:
 * @Return:
 * @Create: 2019/5/23 14:18
 * @version v1.0
 */
public class ResultBean<T> implements Serializable {

    public static final long serialVersionUID = 42L;
    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 500;

    public static final ResultBean<String> SUCCESS = new ResultBean<String>(null);
    public static final ResultBean<String> FAIL = new ResultBean<String>(FAIL_CODE, "fail");
    private int code;
    private String msg = "success";
    private T content;

    public ResultBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBean() {
    }

    public ResultBean(T content) {
        this.content = content;
        this.code = SUCCESS_CODE;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", content=" + content +
                '}';
    }

    public static ResultBean error(Integer code, String message) {

        return new ResultBean(code,message);
    }

    public static ResultBean error(ExceptionEnum exceptionEnum){

        return new ResultBean(exceptionEnum);
    }

}
