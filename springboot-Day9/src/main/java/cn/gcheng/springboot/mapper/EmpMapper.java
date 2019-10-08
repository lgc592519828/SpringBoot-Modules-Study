package cn.gcheng.springboot.mapper;

import cn.gcheng.springboot.entity.Emp;
import org.springframework.stereotype.Repository;

/**
 * @author gcheng.L
 * @create 2019-10-08 16:43
 */
@Repository
public interface EmpMapper {

    Emp findById(Integer empno);


}
