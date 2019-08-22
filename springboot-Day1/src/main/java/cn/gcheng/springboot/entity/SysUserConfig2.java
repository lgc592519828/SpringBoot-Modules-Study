package cn.gcheng.springboot.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 *
 * @author gcheng.L
 * @create 2019-08-21 14:37
 */
@Component
public class SysUserConfig2 {

//    @Value("${user.username}")
    private String username;
//    @Value("${user.age}")
    private int age;
//    @Value("${user.tel}")
    private String tel;

    /**
     * list 自定义配置
     * #{}  EL表达式
     */
//    @Value("#{'${user.books}'.split(',')}")
    private List<String> books;

    /**
     * map 自定义配置
     */
//    @Value("#{${user.map}}")
    private Map<String, String> wife;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public Map<String, String> getWife() {
        return wife;
    }

    public void setWife(Map<String, String> wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "SysUserConfig2{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", books=" + books +
                ", wife=" + wife +
                '}';
    }
}
