package cn.gcheng.springboot.controller;

import cn.gcheng.springboot.entity.SysRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gcheng.L
 * @create 2019-08-21 14:36
 */


@Controller
public class UserConfigController {


    @Autowired
    private SysRandom random;


    @ResponseBody
    @RequestMapping("/configTest")
    public String test() {
        System.out.println(random.toString());
        return "SUCCESS";
    }
}
