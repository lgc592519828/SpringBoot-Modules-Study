package cn.gcheng.springboot.controller;

import cn.gcheng.springboot.entity.SysUser;
import cn.gcheng.springboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gcheng.L
 * @create 2019-10-11 14:34
 */
@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/user/{id}")
    public SysUser findUserById(@PathVariable("id") String id) {
        return sysUserService.findUserById(id);
    }


    @RequestMapping("/user/create")
    public SysUser create() {
        SysUser user = new SysUser();
        user.setUsername("Wang");
        user.setPassword("123456");
        sysUserService.create(user);
        return user;
    }

}
