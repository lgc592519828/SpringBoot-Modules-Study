package cn.gcheng.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springBoot 整合 Druid 单数据源，配置相关监控
 * @author GchengLiu
 */
@SpringBootApplication
@MapperScan("cn.gcheng.springboot.mapper")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
