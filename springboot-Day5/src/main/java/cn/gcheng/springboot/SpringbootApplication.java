package cn.gcheng.springboot;

import cn.gcheng.springboot.common.filter.AccessRecorderFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * springBoot 与 MVC
 */
@SpringBootApplication
public class SpringbootApplication {

    /**
     * 在入口类中注册过滤器Filter
     * @Bean 会将方法中返回对象在springBoot启动的时候放入IOC容器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegiste() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        // 创建并注册过滤器AccessRecorderFilter
        registrationBean.setFilter(new AccessRecorderFilter());
        // 对所有请求进行拦截
        registrationBean.addUrlPatterns("/*");
        // 过滤器名字
        registrationBean.setName("AccessRecorder");
        // 多个过滤器时添加排序。order就决定过滤器执行顺序，数字越小越优先执行
        registrationBean.setOrder(1);

        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
