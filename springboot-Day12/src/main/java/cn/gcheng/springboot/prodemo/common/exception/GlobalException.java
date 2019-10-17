package cn.gcheng.springboot.prodemo.common.exception;

import cn.gcheng.springboot.prodemo.common.result.ResponseMsgUtil;
import cn.gcheng.springboot.prodemo.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gcheng.L
 * @create 2019-10-17 15:22
 */

@RestControllerAdvice
public class GlobalException  extends AbstractErrorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalException.class);

    private static  String errorPath = "/handler/error";

    public GlobalException(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }



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
        LOGGER.error("request uri:{} ,not found exception:{}", request.getRequestURI(), ex);
        return ResponseMsgUtil.noHandlerException();
    }



    /**
     * 拦截500错误
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result<String> nullExceptionHandler(HttpServletRequest req, Exception ex){
        LOGGER.error("request uri:{} server exception:{}", req.getRequestURI(), ex);
        return ResponseMsgUtil.serverException();
    }

//    /**
//     * 重写/error请求, ${server.error.path:${error.path:/error}} IDEA报红无需处理，作用是获取spring底层错误拦截
//     *
//     * @param request
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "${server.error.path:${error.path:/error}}")
//    public Result<String> handleErrors(HttpServletRequest request) throws Exception {
//        HttpStatus status = getStatus(request);
//        if (status == HttpStatus.NOT_FOUND) {
//            throw new NoHandlerFoundException(request.getMethod(),request.getRequestURL().toString(),new HttpHeaders()) ;
//        }
//        return ResponseMsgUtil.noHandlerException();
//    }

    @Override
    public String getErrorPath() {
        return errorPath;
    }
}
