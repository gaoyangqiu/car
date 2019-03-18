package com.carrental.dao;

import com.carrental.entity.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> findRolePermissionByRoleId(@Param("roleId") Long roleId);
}