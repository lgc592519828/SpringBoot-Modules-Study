package cn.gcheng.springboot.service;

import cn.gcheng.springboot.entity.Emp;
import cn.gcheng.springboot.mapper.master.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Emp findByAutoId(Integer empno) {
        return empMapper.findByAutoId(empno);
    }

    public List<Map> findDepts(String dname, Float sal) {
        Map param = new HashMap(16);
        param.put("dname", dname);
        param.put("sal", sal);
        return empMapper.findDepts(param);
    }


    @Transactional(rollbackFor = Exception.class)
    public void save(Emp emp) {
        empMapper.save(emp);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Emp emp) {
        empMapper.update(emp);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer empno) {
        empMapper.delete(empno);
    }
}
