package cn.gcheng.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常分为两种 ：1、异常发生在Controller之后（程序异常 runtimeException类型)
 *              2、异常发生在Controller之前（404之类，或者filter中发生错误）
 *
 * 这5种都是处理Controller之后的异常收集与处理
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
