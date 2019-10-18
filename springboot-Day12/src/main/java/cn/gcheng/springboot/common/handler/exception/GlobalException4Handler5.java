package cn.gcheng.springboot.common.handler.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于第5种处理异常方式：自定义 HandlerExceptionResolver 类处理异常
 * @author gcheng.L
 * @create 2019-10-16 11:46
 */
@Configuration
public class GlobalException4Handler5 implements HandlerExceptionResolver {
    private static  String errorPath = "/handler/error";

    /**
     * 实现resolveException方法，判断异常类型进行跳转
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        //判断不同异常类型，做不同视图跳转
        if(ex instanceof ArithmeticException){
            mv.setViewName(errorPath);
        }
        if(ex instanceof NullPointerException){
            mv.setViewName(errorPath);
        }
        // 添加其他异常类型...
        mv.addObject("error", "Exception5: "+ex.toString());

        return mv;
    }
}
