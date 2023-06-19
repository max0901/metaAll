package com.ohgiraffers.section02.initdestory.subsection02.annotation;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Owner {
@PostConstruct //초기화할떄 실행
public void openShop(){
        System.out.println("사장님이 가게문을 열었습니다 , 쇼핑 ㄱㄱ");
    }
    @PreDestroy //소멸시키기직전에 실행
    public void closeShop(){
        System.out.println("사장님이 가게문을 닫았습니다, 나가주세요");
    }
}
