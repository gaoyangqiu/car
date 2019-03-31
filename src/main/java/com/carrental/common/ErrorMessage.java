package com.carrental.common;



/**
 * @Author: 72038667
 * @Date: 2019/3/16 14:20
 * @Version: 1.0
 */
public enum  ErrorMessage {
    /** 操作成功 */
    SUCCESS(0, "SUCCESS_MSG"),

    /** 操作失败 */
    FAIL(5000, "FAIL_MSG"),

    /** 空指针异常 */
    NullpointerException(5001, "NPE_MSG"),

    /** 自定义异常之返回值为空 */
    NullResponseException(5002, "NRE_MSG");

    ErrorMessage(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private Integer code;
    private  String desc;
}
