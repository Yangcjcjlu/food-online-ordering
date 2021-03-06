package com.example.config;

import com.example.Interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Created by ThinkPad on 2019/4/17.
 */
@Configuration
public class WebMvcConfigure implements WebMvcConfigurer {

    //用来配置静态资源，html,js,css等
   public void addResourceHandlers(ResourceHandlerRegistry registry){
   }

   //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login","/register");

   }

    @Autowired
    private LoginInterceptor loginInterceptor;
}
