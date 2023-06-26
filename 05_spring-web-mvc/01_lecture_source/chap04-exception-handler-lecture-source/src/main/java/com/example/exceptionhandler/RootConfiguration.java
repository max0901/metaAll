package com.example.exceptionhandler;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Controller

public class RootConfiguration {
    //오류 빈으로 만들기
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver exceptionResolver=new SimpleMappingExceptionResolver();
        Properties props=new Properties();
        props.setProperty("java.lang.NullPointerException","error/nullPointer");
        props.setProperty("MemberRegistException","error/memberRegist");

        exceptionResolver.setExceptionMappings(props);
        exceptionResolver.setDefaultErrorView("error/default");
        exceptionResolver.setExceptionAttribute("exceptionmessage");

        return exceptionResolver;
    }
}
