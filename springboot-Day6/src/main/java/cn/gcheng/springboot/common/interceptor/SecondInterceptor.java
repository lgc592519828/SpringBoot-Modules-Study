package cn.gcheng.springboot.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * @author gcheng.L
 * @create 2019-09-17 17:46
 */
public class SecondInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(SecondInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        logger.info("SecondInterceptor preHandle the request");
        String interceptor = request.getParameter("interceptor");
        if (isEmpty(interceptor)) {
            response.getWriter().println("Filtered by SecondInterceptor, " +
                    "please set request parameter \"interceptor\"");
            return false;
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        logger.info("SecondInterceptor postHandle the request");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.info("SecondInterceptor afterCompletion the request");
    }
}
