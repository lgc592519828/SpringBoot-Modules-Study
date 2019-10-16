package cn.gcheng.springboot.common.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * filter 过滤器配置类
 * @author gcheng.L
 * @create 2019-09-24 14:17
 */

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean secondFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        // 创建并注册过滤器AccessRecorderFilter
        registrationBean.setFilter(new SecendIndexFilter());
        // 对所有请求进行拦截
        registrationBean.addUrlPatterns("/*");
        // 过滤器名字
        registrationBean.setName("SecondIndexFilter");
        // 多个过滤器时添加排序。order就决定过滤器执行顺序，数字越小越优先执行
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
