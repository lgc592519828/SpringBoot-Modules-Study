package cn.gcheng.springboot.mapper.master;

import cn.gcheng.springboot.entity.Emp;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    /**
     * 基于mybatis注解实现 @Update() @Insert() @Delete() @Select() 写sql即可
     * @param empno
     * @return
     */
    @Select("SELECT * FROM EMP WHERE EMPNO = #{empno}")
    Emp findByAutoId(Integer empno);

    /**
     * 使用map包含参数
     * @param param
     * @return
     */
    List<Map> findDepts(Map param);

    void save(Emp emp);

    void update(Emp emp);

    void delete(Integer empno);
}
