package com.carrental.shopping;

import com.carrental.common.ErrorMessage;
import com.carrental.common.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 72038667
 * @Date: 2019/3/15 15:07
 * @Version: 1.0
 */
@Controller
public class testController {
    @RequestMapping("test")
    public String test(){
        return "index";
    }


    /**
     * 业务逻辑异常
     */
    @GetMapping(path = "logicException")
    public void logicException() {
        throw ServiceException.le(ErrorMessage.LOGIC_EXCEPTION);
    }

    /**
     * 系统异常
     */
    @GetMapping(path = "systemException")
    public void systemException() {
        throw new NullPointerException("空指针了，哥门!!!");
    }
}
