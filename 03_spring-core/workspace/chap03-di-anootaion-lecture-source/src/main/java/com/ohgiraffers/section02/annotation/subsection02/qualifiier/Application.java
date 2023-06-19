package com.ohgiraffers.section02.annotation.subsection02.qualifiier;

import com.ohgiraffers.section02.annotation.subsection01.primary.PoketmonBattleFiled;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext("com.ohgiraffers.section02.annotation.subscetion03.collection");
        PoketmonBattleFiled poketmonBattleFiled=context.getBean("fieldQualifier", PoketmonBattleFiled.class);

     poketmonBattleFiled.fight();
    }
}
