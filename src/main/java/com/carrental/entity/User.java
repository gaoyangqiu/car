package com.carrental.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;

    private String name;

    private String email;

    private String pswd;

    private Date createTime;

    private Date lastLoginTime;

    private Long status;

    private Long balance;

    private String phone;

    private Integer dflag;
}