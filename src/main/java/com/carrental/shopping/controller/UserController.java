package com.carrental.shopping.controller;

import com.carrental.common.RestResult;
import com.carrental.entity.User;
import com.carrental.shopping.service.UserService;
import com.carrental.shopping.service.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: qgy
 * @Date: 2019/3/24 16:36
 * @Description:
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/userInfo")
    public String index(){
        return "userInfo";
    }

    @RequestMapping("/updateUserInfo")
    public RestResult updateUserInfo(@RequestBody User user){
        userService.updateUserInfo(user);
        return RestResult.success();
    }
}
