package com.ohgifaffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(ContextConfiguration.class);
        View view=context.getBean("view",View.class);
//        System.out.println("=========findAllMembers======");
//        view.findAllMembers();
        System.out.println("=========findById=========");
        view.findMemberById();
    }
}
