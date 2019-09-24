package cn.gcheng.springboot.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.util.StringUtils.isEmpty;

/** 相对比filter过滤器，拦截器更加灵活，类似于AOP
 * @author gcheng.L
 * @create 2019-09-17 17:46
 */
public class FirstInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(FirstInterceptor.class);


    /**
     * preHandle 在请求处理之前进行调用（Controller方法调用之前）
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws IOException
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        logger.info("FirstIndexInterceptor preHandle the request");
        String interceptor = request.getParameter("interceptor");
        if (isEmpty(interceptor)) {
            response.getWriter().println("Filtered by FirstInterceptor, " +
                    "please set request parameter \"interceptor\"");
            return false;
        }
        return true;

    }

    /**
     * postHandle 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后），如果异常发生，则该方法不会被调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        logger.info("FirstIndexInterceptor postHandle the request");
    }

    /**
     * afterCompletion 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.info("FirstIndexInterceptor afterCompletion the request");
    }

}
