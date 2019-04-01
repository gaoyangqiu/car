package com.carrental.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Long id;

    private Integer userId;

    private Integer bicycleId;

    private Date startTime;

    private Date endTime;

    private Integer totalPrice;

    private Integer status;

    private Integer dflag;

    private Integer time;
}