package com.carrental.shopping.shiro;

import com.carrental.common.ServiceException;
import com.carrental.entity.Permission;
import com.carrental.entity.Role;
import com.carrental.entity.User;
import com.carrental.shopping.service.UserService;
import com.google.common.collect.Lists;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Author: 72038667
 * @Date: 2019/3/16 9:47
 * @Version: 1.0
 */

public class MyShiroRealm extends AuthorizingRealm {
    private static final Logger log = LoggerFactory.getLogger(MyShiroRealm.class);
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        log.info("权限认证方法：MyShiroRealm.doGetAuthenticationInfo()");
        List<Permission> permissionList = Lists.newArrayList();
        User token = (User) SecurityUtils.getSubject().getPrincipal();
        Long userId = token.getId();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
        List<Role> roleList = userService.findRolesByUserId(userId);
        Set<String> roleSet = new HashSet<String>();
        for (Role role : roleList) {
            roleSet.add(role.getType());
            List<Permission> temp = userService.findPermissionByRole(role.getId());
            permissionList.addAll(temp);
        }
        //根据用户ID查询权限（permission），放入到Authorization里。
        Set<String> permissionSet = new HashSet<String>();
        if (!CollectionUtils.isEmpty(permissionList)) {
            for (Permission Permission : permissionList) {
                permissionSet.add(Permission.getName());
            }
        }
        info.setStringPermissions(permissionSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("身份验证开始");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", token.getUsername());
        map.put("pswd", String.valueOf(token.getPassword()));
        List<User> users = userService.findUserByMap(map);
        User user = null;
        if (users.size() > 0) {
            user = users.get(0);
        }
        if (null == user) {
            throw new AuthenticationException("账户密码不正确");
        }
        return new SimpleAuthenticationInfo(user, user.getPswd(), getName());
    }
}
