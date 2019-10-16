package cn.gcheng.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 第一种处理异常方式：
 * 自定义异常页面，404，500等
 * @author gcheng.L
 * @create 2019-10-15 8:59
 */

@RestController
public class ExceptionHandler1 {

    @RequestMapping("/handler1/exception")
    public String index() {
        String s = null;
        s.length();
        return "hello world!";
    }

}
