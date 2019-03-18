package com.carrental.shopping.service;

import com.carrental.entity.Permission;
import com.carrental.entity.Role;
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

    /**
     * 查询用户绑定的角色
     * @param userId
     * @return
     */
    List<Role> findRolesByUserId(Long userId);

    /**
     * 根据角色id查询资源
     * @param roleId
     * @return
     */
    List<Permission> findPermissionByRole(Long roleId);
}
