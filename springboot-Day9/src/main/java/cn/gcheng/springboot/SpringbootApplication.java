package cn.gcheng.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springBoot整合mybatis，@MapperScan扫描cn.gcheng.springboot.mapper该路径下的包进行注册
 * @author GchengLiu
 */
@SpringBootApplication
@MapperScan("cn.gcheng.springboot.mapper")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
