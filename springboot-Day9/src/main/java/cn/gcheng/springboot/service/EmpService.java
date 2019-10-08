package cn.gcheng.springboot.service;

import cn.gcheng.springboot.entity.Emp;
import cn.gcheng.springboot.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gcheng.L
 * @create 2019-10-08 16:44
 */
@Service
public class EmpService {

    @Autowired
    private EmpMapper empMapper;

    public Emp findById(Integer empno) {
        return empMapper.findById(empno);
    }


}
