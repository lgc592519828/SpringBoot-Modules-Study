package cn.gcheng.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public void index() {
        System.out.println("indexController");
    }
}
