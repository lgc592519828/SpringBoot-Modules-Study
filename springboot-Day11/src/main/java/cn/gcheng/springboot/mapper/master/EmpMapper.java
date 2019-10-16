package cn.gcheng.springboot.mapper.master;

import cn.gcheng.springboot.entity.Emp;
import org.springframework.stereotype.Repository;

/**
 * @author gcheng.L
 * @create 2019-10-08 16:43
 */
@Repository
public interface EmpMapper {

    /**
     * 基于Mapper接口与xml实现，与注解方式区别是将sql写在xml中
     * @param empno
     * @return
     */
    Emp findById(Integer empno);


    void save(Emp emp);

}
