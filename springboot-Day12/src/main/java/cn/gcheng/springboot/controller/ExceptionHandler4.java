package cn.gcheng.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 第四种处理异常方式：配置 SimpleMappingExceptionResolver 处理异常
 *
 * @author gcheng.L
 * @create 2019-10-16 11:46
 */


@RestController
public class ExceptionHandler4 {

    @RequestMapping("/handler4/exception")
    public String index() {
        int i = 1/0;
        return "hello world!";
    }

}
