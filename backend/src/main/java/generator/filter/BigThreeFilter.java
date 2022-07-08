package generator.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * @author 王明鑫
 * 过滤器
 * */
@Component
public class BigThreeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //在实例化时创建
        System.out.println("过滤器init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //HttpServletRequestWrapper，HttpServletResponseWrapper的使用往往配合过滤器Filter使用
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(response);
        String requestUri = request.getRequestURI();
        System.out.println("进入过滤器的请求地址是" + requestUri);
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("用时"+(System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {
        //在服务关闭时销毁
        System.out.println("销毁过滤器");
    }
}
