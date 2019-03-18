package com.carrental.shopping.shiro;

import lombok.Data;

/**
 * @Author: 72038667
 * @Date: 2019/3/16 9:53
 * @Version: 1.0
 */
@Data
public class ShiroToken {
    private String name;
    private String pswd;

    public ShiroToken(String name, String pswd) {
        this.name = name;
        this.pswd = pswd;
    }
}
