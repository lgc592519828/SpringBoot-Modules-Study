package cn.gcheng.springboot.controller;

import cn.gcheng.springboot.entity.Emp;
import cn.gcheng.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/emp/auto/{id}")
    public Emp empAutoFindById(@PathVariable("id") Integer id) {
        return empService.findByAutoId(id);
    }

    @RequestMapping("/emp/list")
    public List<Map> empAutoFindById(String dname, Float sal) {
        return empService.findDepts(dname, sal);
    }

    @RequestMapping("/emp/create")
    public Emp empCreate() {
        Emp emp = new Emp();
        emp.setEname("Wang");
        emp.setHiredate(new Date());
        emp.setJob("Teacher");
        emp.setSal(1000f);
        emp.setComm(0f);
        emp.setDeptno(30);
        emp.setMgr(null);
        empService.save(emp);
        return emp;
    }

    @RequestMapping("/emp/update")
    public Emp empUpdate() {
        Emp emp = empService.findById(7938);
        emp.setSal(emp.getSal() * 2);
        empService.update(emp);
        return emp;
    }

    @RequestMapping("/emp/delete/{id}")
    public String empDelete(@PathVariable("id")Integer empno) {
        empService.delete(empno);
        return "Success!";
    }
}
