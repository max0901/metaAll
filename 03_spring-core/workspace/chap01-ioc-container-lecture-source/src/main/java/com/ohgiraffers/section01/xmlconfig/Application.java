package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context= new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");
            //xml 설정 가져오기
//        Member member=(Member) context.getBean("member");
        //bin의 id로가져오는방법
//        Member member=context.getBean(Member.class);
        //bin의 type으로 가져오는방법

        Member member=context.getBean("member",Member.class);

        System.out.println("member = " + member);

    }
}
