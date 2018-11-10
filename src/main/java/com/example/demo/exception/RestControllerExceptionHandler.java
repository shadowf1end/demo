package com.example.demo.exception;

import com.example.demo.common.vo.ResultMap;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Exrickx
 */
@Slf4j
@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(WxErrorException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ResultMap handleWeChatException(WxErrorException e) {

        String errorMsg = "WeChat exception";
        if (e != null) {
            errorMsg = e.getMessage();
            log.error("", e);
        }
        return ResultMap.error(500, errorMsg);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ResultMap handleException(Exception e) {

        String errorMsg = "System Exception";
        if (e != null) {
            errorMsg = e.getMessage();
            log.error("", e);
        }
        return ResultMap.error(500, errorMsg);
    }
}
