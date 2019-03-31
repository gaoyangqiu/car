package com.carrental.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: qgy
 * @Date: 2019/3/31 16:05
 * @Description:
 */

@Data
public class PageBean<T> {

    // 当前页
    private Integer currentPage = 1;
    // 每页显示的总条数
    private Integer pageSize = 10;
    // 总条数
    private Integer totalNum;
    // 总页数
    private Integer totalPage;
    // 开始索引
    private Integer startIndex;
    // 分页结果
    private T items;


}
