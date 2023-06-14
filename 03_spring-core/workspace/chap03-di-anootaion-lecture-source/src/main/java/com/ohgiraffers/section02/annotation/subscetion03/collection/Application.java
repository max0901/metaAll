package com.ohgiraffers.section02.annotation.subscetion03.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext("com.ohgiraffers.section02");
      PocketmonBattleFiled pocketmonBattleFiled=  context.getBean("fieldCollection", PocketmonBattleFiled.class);

      pocketmonBattleFiled.fight();
    }
}
