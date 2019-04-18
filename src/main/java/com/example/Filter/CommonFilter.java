package com.example.Filter;

import com.example.Model.Customer;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ThinkPad on 2019/4/18.
 */
@Component
@WebFilter(filterName = "commonFilter",urlPatterns = "/**")
public class CommonFilter extends HttpFilter {

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException,
            ServletException {
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String uri = requestUri.substring(contextPath.length());
        if(uri.endsWith(".css")||uri.endsWith(".js")||uri.endsWith(".png")){
            filterChain.doFilter(request,response);
            return;
        }
        if("/login".equals(uri)){
            filterChain.doFilter(request,response);
            return;
        }
        else if("/fore/foreLogin".equals(uri)){
            filterChain.doFilter(request,response);
            return;
        }
        else {
            Customer customer = (Customer) request.getSession().getAttribute("customer");
            if(customer==null){
                response.sendRedirect("login");
                return;
            }
            filterChain.doFilter(request,response);
            return;
        }
    }

//    /**
//     * 执行过滤操作
//     */
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//            chain.doFilter(request, response);
//        System.out.println("执行过滤操作。。。");
//    }
//
//    /**
//     * 过滤器初始化
//     */
//    @Override
//    public void init(FilterConfig config) throws ServletException {
//        System.out.println("过滤器初始化。。。");
//    }
//
//    /**
//     * 过滤器销毁
//     */
//    @Override
//    public void destroy() {
//        System.out.println("过滤器销毁。。。");
//    }
//

}
