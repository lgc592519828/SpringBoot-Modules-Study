package cn.gcheng.springboot.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import java.io.IOException;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * 通过 @Bean 注解来配置
 * @author gcheng.L
 * @create 2019-09-16 11:14
 */
public class SecendIndexFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(SecendIndexFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("{} is init.", logger.getName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("{} is doFilter.", logger.getName());
        String filter = servletRequest.getParameter("filter");
        if (isEmpty(filter)) {
            servletResponse.getWriter().println("Filtered by SecondIndexFilter, " +
                    "please set request parameter \"filter\"");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("{} post filter the response", logger.getName());
    }

    @Override
    public void destroy() {
        logger.info("{} is destroy", logger.getName());
    }
}
