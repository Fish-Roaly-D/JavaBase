package com.roily.root.demo.common.common.exception;

import com.roily.root.demo.common.util.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0.0
 * @Description 屈居异常处理器
 * @ClassName GlobalCustomExceptionHandler.java
 * @author: RoilyFish
 * @date: 2022/5/27 0:30
 */
@RestControllerAdvice
@Slf4j
public class GlobalCustomExceptionHandler {

    /**
     * 未知异常
     *
     * @param e 异常
     * @return ResultVo<String>
     */
    @ExceptionHandler(value = Exception.class)
    public ResultVo<String> unKnownException(Exception e) {
        log.error("系统出现异常:{}", e.getMessage());
        return ResultVo.error(e.getMessage());
    }

    /**
     * 全局异常
     *
     * @param globalCustomException 全局异常
     * @return ResultVo<String>
     */
    @ExceptionHandler(value = GlobalCustomException.class)
    public ResultVo<String> globalCustomException(GlobalCustomException globalCustomException) {
        log.error("系统出现异常:{}", globalCustomException.getMsg());
        return ResultVo.error(globalCustomException.getMsg());
    }

}
