package com.carrental.entity;

import lombok.Data;

@Data
public class Permission {
    private Long id;

    private String url;

    private String name;


    private Long pid;
}