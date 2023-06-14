package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.Member;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ContextConfiguration {
    @Bean
    public Account accountGenerator(){
        return  new PersonalAccount("111-222-333",1000);
    }
    @Bean
    public Member member(){
        //생성자 주입
//        return new Member(1,"홍길","010-55-485","hong@naver.com",accountGenerator());
        //setter주입
        Member member=new Member();
        member.setSequence(1);
        member.setName("홍길동");
        member.setEmail("masxc@naver.com");
        member.setPhone("101-2424-124");
        member.setPersonalAccount(accountGenerator());
        return member;
    }
}
