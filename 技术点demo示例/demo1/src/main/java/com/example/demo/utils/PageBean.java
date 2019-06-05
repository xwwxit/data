package com.example.demo.utils;

import lombok.Data;

import java.util.List;

/**
 * created by zhangtao on 2019/5/23
 */
@Data
public class PageBean<T> {
    //当前页
    private Integer currentPage;
    //每页显示的总条数
    private Integer pageSize;
    //总条数
    private Integer totalNum;
    //是否还有下一页
    private Integer isMore;
    //总页数
    private Integer totalPage;
    //开始索引
    private Integer startIndex;
    //分页结果
    private List<T> items;
}
