package com.carrental.shopping.service;

import com.carrental.common.RestResult;
import com.carrental.entity.Bicycle;
import com.carrental.entity.PageBean;
import com.carrental.shopping.service.vo.CreateRentVo;
import com.carrental.shopping.vo.QueryBaseVo;

import java.util.List;

/**
 * @Author: qgy
 * @Date: 2019/3/31 16:15
 * @Description:
 */
public interface RentService {
    PageBean<List<Bicycle>> getRentList(QueryBaseVo queryvo);

    List<Bicycle> getRentListAll();

    RestResult createRent(CreateRentVo rentVo);

}
