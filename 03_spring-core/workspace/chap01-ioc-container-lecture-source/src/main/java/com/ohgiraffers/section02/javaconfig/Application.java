package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context=
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
                                                        //이 클래스에 대한 사용 전권을 주는것

        Member member=context.getBean("getMember",Member.class);
            //getBean으로 객체를 가져옴
        System.out.println("member = " + member);
    }
}
