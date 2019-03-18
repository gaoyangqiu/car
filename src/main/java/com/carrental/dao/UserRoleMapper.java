package com.carrental.dao;

import com.carrental.entity.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> findUserRoleByUserId(@Param("userId") Long userId);
}