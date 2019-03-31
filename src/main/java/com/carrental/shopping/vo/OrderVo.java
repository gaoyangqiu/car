package com.carrental.shopping.vo;

import com.carrental.entity.Order;
import lombok.Data;

/**
 * @Author: qgy
 * @Date: 2019/3/31 22:28
 * @Description:
 */
@Data
public class OrderVo extends Order{

    private String bicycleName;

    private String statusName;

    private String bicycleTypeName;

    private String timeShow;
}
