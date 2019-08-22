package cn.gcheng.springboot.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gcheng.L
 * @create 2019-08-21 18:05
 */
@Component
@ConfigurationProperties(prefix = "rd")
public class SysRandom {

    private String value;

    private int number;

    private long bignumber;

    private int number1;

    private int number2;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getBignumber() {
        return bignumber;
    }

    public void setBignumber(long bignumber) {
        this.bignumber = bignumber;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    @Override
    public String toString() {
        return "SysRandom{" +
                "value='" + value + '\'' +
                ", number=" + number +
                ", bignumber=" + bignumber +
                ", number1=" + number1 +
                ", number2=" + number2 +
                '}';
    }
}
