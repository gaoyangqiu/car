package com.carrental.shopping.service.enumt;

/**
 * @Author: qgy
 * @Date: 2019/4/1 22:50
 * @Description:
 */
public enum  UserStatus {
 ZHANGCHANG(1,"正常"),BUZHANGCHANG(2,"不正常");
    private Integer status;

    private String desc;

     UserStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static UserStatus  getUserStatus(Integer status){

        for (UserStatus userStatus : UserStatus.values()) {

            if (status==userStatus.status){
                return userStatus;
            }
        }
        return  null;
    }
}
