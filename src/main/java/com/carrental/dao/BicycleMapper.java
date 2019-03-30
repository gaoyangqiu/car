package com.carrental.dao;

import com.carrental.entity.Bicycle;

public interface BicycleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bicycle record);

    int insertSelective(Bicycle record);

    Bicycle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bicycle record);

    int updateByPrimaryKey(Bicycle record);
}