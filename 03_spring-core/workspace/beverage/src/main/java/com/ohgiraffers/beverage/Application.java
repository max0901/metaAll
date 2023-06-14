package com.ohgiraffers.beverage;

import com.ohgiraffers.common.BeverageDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }
        BeverageDAO beverageDAO = context.getBean("beverageDAO", BeverageDAO.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("기능을 고르세요(1.물건추가,2.물건사기)");
        int select=sc.nextInt();
        if(select==1){
            System.out.println("물건이름 등록");
            String name=sc.next();
            System.out.println("가격 등록");
            int price=sc.nextInt();
            beverageDAO.addBeverage(name,price);
        }
        else if(select==2) {
            System.out.println("가지고있는 값을 입력하세요");
            int money = sc.nextInt();
            System.out.println("1.사이다,2.콜라,3.밀키스 중에 번호를 선태하세요 ");
            int prodNum = sc.nextInt();
            try{

            beverageDAO.Caculator(money, beverageDAO.findProdNum(prodNum).getPrice());
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

//        System.out.println(context.getBeanDefinitionNames());





    }
}
