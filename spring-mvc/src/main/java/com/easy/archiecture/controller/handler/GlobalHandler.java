package com.easy.archiecture.controller.handler;

import com.easy.archiecture.entity.vo.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionConverter(Exception e) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(10002);
        responseResult.setMsg("服务器出错了~");
        responseResult.setData("aaa");

        return responseResult;
    }
}
