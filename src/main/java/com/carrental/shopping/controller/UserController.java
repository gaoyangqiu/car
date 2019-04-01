package com.carrental.shopping.controller;

import com.carrental.common.RestResult;
import com.carrental.entity.User;
import com.carrental.shopping.service.UserService;
import com.carrental.shopping.service.vo.UserInfoVo;
import com.carrental.shopping.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping("/userManagement")
    public String userManagement() {
        return "user";
    }
    @RequestMapping("/updateUserInfo")
    public RestResult updateUserInfo(@RequestBody User user){
        userService.updateUserInfo(user);
        return RestResult.success();
    }

    @RequestMapping("/userList")
    @ResponseBody
    public List<UserVo> userList(){
       return userService.userList();
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public RestResult updateUser(@RequestBody UserVo updateVo){
        userService.updateUser(updateVo);
        return RestResult.success();
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public RestResult addUser(@RequestBody UserVo updateVo){
        userService.addUser(updateVo);
        return RestResult.success();
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public RestResult deleteUser(Integer userId){
        userService.deleteUser(userId);
        return RestResult.success();
    }

}
