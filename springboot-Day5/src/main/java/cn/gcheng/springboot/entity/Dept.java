package cn.gcheng.springboot.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dept {
    private Integer deptno;
    private String dname;
    private Date foundingTime;

    public Dept(Integer deptno, String dname, String time) {
        this.deptno = deptno;
        this.dname = dname;
        try {
            foundingTime = new SimpleDateFormat("yyyy-MM-dd").parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Date getFoundingTime() {
        return foundingTime;
    }

    public void setFoundingTime(Date foundingTime) {
        this.foundingTime = foundingTime;
    }
}
