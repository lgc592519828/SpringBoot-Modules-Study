package cn.gcheng.springboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 第二种处理异常方式：@ExceptionHandle 注解处理异常
 * @author gcheng.L
 * @create 2019-10-15 8:59
 */

@RestController
public class ExceptionHandler2 {

    @RequestMapping("/handler2/exception")
    public String index() {
        String s = null;
        s.length();
        return "hello world!";
    }


    /**
     * 用于拦截本类的java.lang.NullPointerException异常
     * 该方法需要返回一个 ModelAndView：目的是可以让我们封装异常信息以及视图的指定
     * 参数 Exception e:会将产生异常对象注入到方法中
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView nullExceptionHanlder(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("error", "ExceptionHandler2: "+e.toString());
        mv.setViewName("/handler/error");
        return mv;
    }


}
