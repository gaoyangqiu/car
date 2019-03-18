package com.carrental.shopping.controller;

import com.carrental.common.ErrorMessage;
import com.carrental.common.RestResult;
import com.carrental.common.ServiceException;
import com.carrental.shopping.vo.LoginVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 72038667
 * @Date: 2019/3/15 15:07
 * @Version: 1.0
 */
@Controller
public class testController {
    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("adminLogin")
    public String adminLogin(){
        return "adminlogin";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("indexAdmin")
    public String indexAdmin(){
        return "indexAdmin";
    }

    @RequestMapping("403")
    public String testtest(){
        return "403";
    }
    /**
     * ajax登录请求
     * @param vo
     * @return
     */
    @RequestMapping(value="ajaxLogin",method= RequestMethod.POST)
    @ResponseBody
    public RestResult submitLogin(@RequestBody LoginVo vo) {
        UsernamePasswordToken token = new UsernamePasswordToken(vo.getName(), vo.getPswd());
        SecurityUtils.getSubject().login(token);
        return RestResult.success();
    }

    /**
     * 业务逻辑异常
     */
    @GetMapping(path = "logicException")
    public void logicException() {
        throw new ServiceException(ErrorMessage.NullpointerException.getDesc());
    }

    /**
     * 系统异常
     */
    @GetMapping(path = "systemException")
    public void systemException() {
        throw new NullPointerException("空指针了，哥门!!!");
    }
}
