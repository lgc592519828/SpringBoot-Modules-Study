package cn.gcheng.springboot.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author gcheng.L
 * @create 2019-09-11 15:56
 */
public class AccessRecorderFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(AccessRecorderFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String ua = request.getHeader("user-agent");
        String ip = request.getRemoteAddr();
        String uri = request.getRequestURI();
        // 过滤掉静态资源，最好配置在配置文件中读取。
        if (uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".map") || uri.endsWith(".jpg") || uri.endsWith(".woff")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        Long st = System.currentTimeMillis();

        // 将请求向后发送到Controller处理
        filterChain.doFilter(servletRequest, servletResponse);
        Long et = System.currentTimeMillis();
        logger.info("uri:{},ip:{},time:{},ua:{}", uri, ip, et-st, ua);



    }

    @Override
    public void destroy() {

    }
}
