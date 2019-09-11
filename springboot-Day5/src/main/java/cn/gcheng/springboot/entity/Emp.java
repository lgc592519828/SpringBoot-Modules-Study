package cn.gcheng.springboot.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private Date hiredate;
    private Float sal;
    private String dname;
    private String photoFile;


    public Emp(Integer empno, String ename, String job, String hiredate, Float sal, String dname) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        try {
            this.hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(hiredate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.sal = sal.floatValue();
        this.dname = dname;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Float getSal() {
        return sal;
    }

    public void setSal(Float sal) {
        this.sal = sal;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(String photoFile) {
        this.photoFile = photoFile;
    }
}
