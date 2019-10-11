package cn.gcheng.springboot.service;

import cn.gcheng.springboot.entity.Emp;
import cn.gcheng.springboot.mapper.master.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Transactional(rollbackFor = Exception.class,value = "masterTransactionManager")
    public void save(Emp emp) {
        empMapper.save(emp);
    }

}
