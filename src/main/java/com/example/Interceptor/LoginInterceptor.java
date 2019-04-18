package com.example.Interceptor;


import com.example.Model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ThinkPad on 2019/4/17.
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Customer customer = (Customer)session.getAttribute("customer");
        if(customer ==null){
            return false;
        }
        else {
            return true;
        }

    }
}
