package cn.gcheng.springboot.common.handler.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用于第三种处理异常方式：@ControllerAdvice/@RestControllerAdvice + @ExceptionHandler 注解处理异常
 * @author gcheng.L
 * @create 2019-10-16 11:46
 */

@RestControllerAdvice
public class GlobalException {

    /**
     * 用于拦截本类的java.lang.NullPointerException异常
     * 该方法需要返回一个 ModelAndView：目的是可以让我们封装异常信息以及视图的指定
     * 参数 Exception e:会将产生异常对象注入到方法中
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView nullExceptionHanlder(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("error", "ExceptionHandler3: "+e.toString());
        mv.setViewName("/handler2/error1");
        return mv;
    }


}
