package com.mkx.seumedia.config;

import com.mkx.seumedia.interceptors.OperateInteceport;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new OperateInteceport()).addPathPatterns("/**").excludePathPatterns("/user/login","/user/regist");
    }
}
