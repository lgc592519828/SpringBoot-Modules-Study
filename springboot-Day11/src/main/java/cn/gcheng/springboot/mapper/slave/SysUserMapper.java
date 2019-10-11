package cn.gcheng.springboot.mapper.slave;

import cn.gcheng.springboot.entity.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @author gcheng.L
 * @create 2019-10-11 14:35
 */
@Repository
public interface SysUserMapper {

    SysUser findUserById(String id);

    void create(SysUser user);

}
