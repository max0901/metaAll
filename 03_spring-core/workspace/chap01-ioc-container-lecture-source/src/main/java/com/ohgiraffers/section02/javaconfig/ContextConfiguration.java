package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//어노테이션으로 설정파일로 만듬 ,configuration으로 객체를만들고
public class ContextConfiguration {
    @Bean //member라는 이름의 bean생성
    public Member getMember(){
    return new Member(1,"user01","pass01","홍길동");

    }
}
