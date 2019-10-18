package cn.gcheng.springboot.prodemo.common.exception;

import cn.gcheng.springboot.prodemo.common.result.ResponseUtil;
import cn.gcheng.springboot.prodemo.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一处理异常，并打印日志
 * 也可以AOP记录异常信息日志问题
 * @author gcheng.L
 * @create 2019-10-17 15:22
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler{

    /**
     * 可以添加自定义异常拦截
     */
//  ------------------------------------------------------------------
    /**
     * 404的拦截.
     *
     * @param request
     * @param ex
     * @return
     */
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<String> notFound(HttpServletRequest request, Exception ex) {
        log.error("request uri:{} ,not found exception:{}", request.getRequestURI(), ex);
        return ResponseUtil.noHandlerException(request.getRequestURI(),null);
    }

    /**
     * 拦截500错误
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result<String> nullExceptionHandler(HttpServletRequest req, Exception ex){
        log.error("request uri:{} server exception:{}", req.getRequestURI(), ex);
        return ResponseUtil.serverException(req.getRequestURI());
    }

}
