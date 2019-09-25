package cn.gcheng.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot默认使用的是内嵌tomcat，修改这个默认服务器，使用jetty或者undertow启动服务
 *
 *
 */
@SpringBootApplication
public class SpringbootApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
