package com.carrental.shopping.service.impl;

import com.carrental.dao.UserMapper;
import com.carrental.entity.User;
import com.carrental.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 72038667
 * @Date: 2019/3/16 10:48
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;
    @Override
    public List<User> findUserByMap(Map map) {

        return userDao.findUserByMap(map);
    }
}
