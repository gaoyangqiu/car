package com.carrental.shopping.controller;

import com.carrental.common.RestResult;
import com.carrental.entity.Permission;
import com.carrental.entity.Role;
import com.carrental.entity.User;
import com.carrental.shopping.service.UserService;
import com.carrental.shopping.service.vo.PermissionVo;
import com.carrental.shopping.service.vo.UserInfoVo;
import com.carrental.shopping.vo.LoginVo;
import com.google.common.collect.Lists;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * @Author: 72038667
 * @Date: 2019/3/15 15:07
 * @Version: 1.0
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    private static final Logger log= LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("show")
    public String show(){
        return "show";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("getUserInfo")
    @ResponseBody
    public Object getUserInfo(){
        Subject subject= SecurityUtils.getSubject();
        PrincipalCollection res=subject.getPrincipals();
        List ress=res.asList();
        Object o=ress.get(0);
        return o;
    }

    @RequestMapping("menus")
    @ResponseBody
    public List<Permission> getMenus(HttpSession session){
        List<Permission> permissionVos= Lists.newArrayList();
        Subject subject= SecurityUtils.getSubject();
        PrincipalCollection res=subject.getPrincipals();
        User user= (User) session.getAttribute("user");
        List<Role> roles= userService.findRolesByUserId(user.getId());
        if (!CollectionUtils.isEmpty(roles)){
            for (Role role : roles) {
                List<Permission> vos=userService.findPermissionByRole(role.getId());
                List<Permission> vo=Lists.newArrayList();
                if (!CollectionUtils.isEmpty(vos)){
                    for (Permission permission : vos) {
                        if (permission.getId()!=1){
                            permissionVos.add(permission);
                        }
                    }
                }
            }
        }

        return permissionVos;
    }

    @RequestMapping("index")
    public String index(){
        return "index1";
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
    @RequestMapping(value="ajaxLogin")
    @ResponseBody
    public RestResult submitLogin(@RequestBody LoginVo vo, HttpSession session) {
        RestResult result=new RestResult();
        UsernamePasswordToken token = new UsernamePasswordToken(vo.getName(), vo.getPswd());
        Subject subject= SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch (UnknownAccountException e) {
            result.setErrorMessage("账户不存在");
            return result;
        } catch (DisabledAccountException e) {
            result.setErrorMessage("账户存在问题");
            return result;
        } catch (AuthenticationException e) {
            result.setErrorMessage("密码错误");
            return result;
        } catch (Exception e) {
            log.info("登陆异常", e);
            result.setErrorMessage("登陆异常");
            return result;
        }
        result=RestResult.success();
        PrincipalCollection res=subject.getPrincipals();
        List ress=res.asList();
        log.info("{}登录成功",ress.get(0).toString());
        result.setData(ress);
        session.setAttribute("user",ress.get(0));
        return result;
    }



}
