package cn.gcheng.springboot.service;

import cn.gcheng.springboot.entity.SysUser;
import cn.gcheng.springboot.mapper.slave.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gcheng.L
 * @create 2019-10-11 14:35
 */
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public SysUser findUserById(String id) {
        return sysUserMapper.findUserById(id);
    }

    @Transactional(rollbackFor = Exception.class,value = "slaveTransactionManager")
    public void create(SysUser user) {
        sysUserMapper.create(user);
    }
}
