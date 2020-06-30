package me.neoyang.yangtuoserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @name: InterceptorConfig
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-30 16:46
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("===Interceptors===" + authenticationInterceptor);
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/**");    // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
    }
}