package com.carrental.common;

import lombok.Data;

/**
 * @Author: 72038667
 * @Date: 2019/3/16 12:05
 * @Version: 1.0
 */
@Data
public class RestResult {
    /**
     * 成功或者失败的code错误码
     */
    private String code;
    /**
     * 成功时返回的数据，失败时返回具体的异常信息
     */
    private Object data;
    /**
     * 请求失败返回的提示信息，给前端进行页面展示的信息
     */
    private Object errorMessage;

    public RestResult(String code, Object data, Object errorMessage) {
        this.code = code;
        this.data = data;
        this.errorMessage = errorMessage;
    }
}
