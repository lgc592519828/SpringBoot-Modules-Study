package cn.gcheng.springboot.common.handler.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * 用于第四种处理异常方式：配置 SimpleMappingExceptionResolver 处理异常
 * 这种方式有很明显的缺点，无法打印异常信息
 * 这种方式有很明显的缺点，无法打印异常信息
 * 这种方式有很明显的缺点，无法打印异常信息
 * @author gcheng.L
 * @create 2019-10-16 11:46
 */

@Configuration
public class GlobalException4Handler4 {
    private static  String errorPath = "/handler/error";
    /**
     * 该方法必须要有返回值。返回值类型必须是： SimpleMappingExceptionResolver
     * @return
     */
    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        // 参数一：异常的类型，注意必须是异常类型的全名 参数二：视图名称
        properties.put("java.lang.NullPointerException",errorPath);
        properties.put("java.lang.ArithmeticException",errorPath);

        // 设置异常与视图映射信息的
        resolver.setExceptionMappings(properties);
        return resolver;
    }

}
