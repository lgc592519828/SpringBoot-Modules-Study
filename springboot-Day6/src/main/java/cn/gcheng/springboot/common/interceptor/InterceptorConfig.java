package cn.gcheng.springboot.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 * @author gcheng.L
 * @create 2019-09-24 14:54
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private Logger logger = LoggerFactory.getLogger(InterceptorConfig.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FirstInterceptor()).addPathPatterns("/*");
        registry.addInterceptor(new SecondInterceptor()).addPathPatterns("/*");
        logger.info("Register FirstInterceptor and SecondInterceptor onto InterceptorRegistry");
    }
}
