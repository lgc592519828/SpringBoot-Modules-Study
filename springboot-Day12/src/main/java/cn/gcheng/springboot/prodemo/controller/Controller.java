package cn.gcheng.springboot.prodemo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 添加实际开发中，返回JSON形式的统一异常处理
 * 返回格式为JSON
 *
 *
 * @author GchengLiu
 */
@RestController
public class Controller {

    @RequestMapping("/index")
    public String index() {
        String s = null;
        s.length();

        return "hello world";
    }
}
