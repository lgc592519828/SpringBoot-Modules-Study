package cn.gcheng.springboot.controller;

import cn.gcheng.springboot.entity.Emp;
import cn.gcheng.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gcheng.L
 * @create 2019-10-08 16:43
 */

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/emp/{id}")
    public Emp empFindById(@PathVariable("id") Integer id) {
        return empService.findById(id);
    }
}
