package com.ohgiraffers.section02.annotation.subsection01.primary;

import org.springframework.stereotype.Component;

@Component

public class Pikachu implements Poketmon {
    @Override
    public void attack() {
        System.out.println("피카츄 백만볼트!!");
    }
}
