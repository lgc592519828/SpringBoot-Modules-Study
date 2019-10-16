package cn.gcheng.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 第三种处理异常方式：@ControllerAdvice/@RestControllerAdvice + @ExceptionHandler 注解处理异常
 * 区别第二种，全局化，方便统一管理
 * @author gcheng.L
 * @create 2019-10-16 11:46
 */


@RestController
public class ExceptionHandler3 {

    @RequestMapping("/handler3/exception")
    public String index() {
        String s = null;
        s.length();
        return "hello world!";
    }

}
