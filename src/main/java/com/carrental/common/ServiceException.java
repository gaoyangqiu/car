package com.carrental.common;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author: 72038667
 * @Date: 2019/3/16 14:20
 * @Version: 1.0
 */
@Data
public class ServiceException extends RuntimeException{
    /**
     * 异常信息
     */
    private String errorMsg;
    /**
     * 错误码
     */
    private String code;


    public ServiceException(String errorMsg) {
        super(errorMsg);
        this.code = errorMsg.substring(0, 5);
        this.errorMsg = errorMsg.substring(6);
    }


}
