package cn.gcheng.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author gcheng.L
 * @create 2019-08-19 16:26
 */

@Controller
public class MyController {

    @RequestMapping("/index")
    public String test() {
        return "idx";
    }

    @RequestMapping("/dateTest")
    @ResponseBody
    public Date test(Date sdate) {
        System.out.println(sdate);
        return sdate;
    }
}
