package com.aqi.zuobiji.Controller;

import com.aqi.zuobiji.Service.ex.ServiceException;
import com.aqi.zuobiji.Utils.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制层基类
 * */
public class BaseController {
    public static final int OK = 200;   //操作成功的状态码
    
    @ExceptionHandler({ServiceException.class})     //统一处理抛出的异常
    public JsonResult handleExcetion(Throwable e){
        JsonResult jsonResult = new JsonResult();
        /** 异常处理
         * 未知异常为3000
         * Service层的异常为4000
         */
        if (e instanceof ServiceException){
            jsonResult.setState(4000);
            jsonResult.setMessage(e.getMessage());
        }else {
            jsonResult.setState(3000);
            jsonResult.setMessage("产生未知异常！");
        }
        
        return jsonResult;
    }
    
    
}
