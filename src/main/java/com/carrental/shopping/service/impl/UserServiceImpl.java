package com.carrental.shopping.service.impl;

import com.carrental.dao.*;
import com.carrental.entity.*;
import com.carrental.shopping.service.UserService;
import com.carrental.shopping.vo.UserVo;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    @Autowired
    private UserRoleMapper userRoleDao;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<User> findUserByMap(Map map) {

        return userDao.findUserByMap(map);
    }

    @Override
    public List<Role> findRolesByUserId(Long userId) {
        List<Long> roleIds= Lists.newArrayList();
        List<UserRole> userRoles=userRoleDao.findUserRoleByUserId(userId);
        if (!CollectionUtils.isEmpty(userRoles)){
            for (UserRole userRole : userRoles) {
                roleIds.add(userRole.getRid());
            }
        }
        if (!CollectionUtils.isEmpty(roleIds)){
            List<Role> roles=roleMapper.findRolesByIds(roleIds);
            return roles;
        }
        return null;
    }

    @Override
    public List<Permission> findPermissionByRole(Long roleId) {
        List<Long> permissionIds=Lists.newArrayList();
        List<RolePermission> rolePermissions=rolePermissionMapper.findRolePermissionByRoleId(roleId);
        if (!CollectionUtils.isEmpty(rolePermissions)) {
            for (RolePermission rolePermission : rolePermissions) {
                permissionIds.add(rolePermission.getPid());
            }
        }
        if (!CollectionUtils.isEmpty(permissionIds)){
            List<Permission> permissions=permissionMapper.findPermissionByIds(permissionIds);
            return permissions;
        }
        return null;
    }

    @Override
    public void updateUserInfo(User user) {

        userDao.updateByPrimaryKeySelective( user);
    }

    @Override
    public List<UserVo> userList() {
        List<UserVo> userVos=Lists.newArrayList();

        //查询所有角色为roleId为2的用户,roleId为2是用户,1是管理员
        List<UserRole> userRoles=userRoleDao.findUserList();
        if (!CollectionUtils.isEmpty(userRoles)){
            for (UserRole userRole : userRoles) {
                UserVo userVo=new UserVo();
                User user=userDao.selectByPrimaryKey(userRole.getUid());
                BeanUtils.copyProperties(user,userVo);
                userVos.add(userVo);
            }
        }
        return userVos;
    }

    @Override
    public void updateUser(UserVo updateVo) {
        userDao.updateByPrimaryKeySelective(updateVo);
    }

    @Override
    public void deleteUser(Integer userId) {
        userDao.deleteByPrimaryKey(userId.longValue());
    }

    @Override
    public void addUser(UserVo updateVo) {
        userDao.insertSelective(updateVo);
        UserRole userRole=new UserRole();
        //用户的角色id是2,管理员是1
        userRole.setRid(Long.valueOf(2));
        userRole.setUid(updateVo.getId());
        userRoleDao.insertSelective(userRole);
    }
}
