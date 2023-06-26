package com.example.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    //webmvcconfugurer web관련된 confifuration

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new StopWatchInterceptor(new MenuService())).addPathPatterns("/stopwatch")
                                                                            //*로 설정하면 모든걸 인터셉트한다
               .addPathPatterns("/*")
               .excludePathPatterns("/css/**")
               .excludePathPatterns("/js/**")
               .excludePathPatterns("/img/**");

    }
}
