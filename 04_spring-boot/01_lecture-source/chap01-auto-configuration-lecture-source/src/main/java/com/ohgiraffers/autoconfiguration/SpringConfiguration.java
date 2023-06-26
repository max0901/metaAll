package com.ohgiraffers.autoconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Configuration
public class SpringConfiguration {
    
    @Value("${test.value}")
    public String value;

    @Value("${test.list}")
//    public List<String> list;
    public String[] list;
    @Value("${test.greeting}")
    private String greeting;
    @Value("${test.array}")
    private Set<String> array;

    @Bean
    public Object prpertyReadTest(){
        System.out.println("value = " + value);

//        list.forEach(System.out::println);
//        Arrays.stream(list).forEach(System.out::println);
        System.out.println("greeting = " + greeting);
        array.forEach(System.out::println);
        return  new Object();
    }
}
