package com.ohgiraffers.section03.subsection01.java;

import com.ohgiraffers.common.Member;
import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(ContextConfiguration.class);
        //컨테이너 만들기
        
     String[] beanNames=   context.getBeanDefinitionNames();
     //가지고 있는 bean배열로 반환
        for(String beanName:beanNames){
            System.out.println("beanName = " + beanName);
        }

        MemberDAO memberDAO=context.getBean("memberDAO",MemberDAO.class);

        System.out.println(memberDAO.findMenberBySequence(1));
        System.out.println(memberDAO.save(new Member(3,"user03","pass03","신사")));
        //회원 추가후 추가 성공하면 true
        System.out.println(memberDAO.findMenberBySequence(3));
        //회원 번호로 조회
    }
}
