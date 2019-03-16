package com.carrental.shopping.service;

import com.carrental.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @Author: 72038667
 * @Date: 2019/3/16 10:48
 * @Version: 1.0
 */
public interface UserService {

    /**
     * 根据map查找用户
     * @param map
     * @return
     */
    List<User> findUserByMap(Map map);
}
