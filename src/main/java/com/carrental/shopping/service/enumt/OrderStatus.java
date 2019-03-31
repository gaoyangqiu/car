package com.carrental.shopping.service.enumt;

/**
 * @Author: qgy
 * @Date: 2019/3/31 21:27
 * @Description:
 */
public enum  OrderStatus {
    WEIZHIFU(0,"未支付"), YIZHIFU(1,"已支付"),YIGUIHUAN(2,"已归还");

    private Integer status;

    private String desc;

    OrderStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static OrderStatus getOrderStatus(Integer status){
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (status==orderStatus.getStatus()){
                return orderStatus;
            }
        }
        return null;
    }
    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
