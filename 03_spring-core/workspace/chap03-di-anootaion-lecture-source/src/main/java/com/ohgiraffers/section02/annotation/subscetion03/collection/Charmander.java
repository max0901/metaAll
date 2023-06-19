package com.ohgiraffers.section02.annotation.subscetion03.collection;

import org.springframework.stereotype.Component;

@Component
public class Charmander implements Poketmon {
    @Override
    public void attack() {
        System.out.println("파이리 공격!!");
    }
}
