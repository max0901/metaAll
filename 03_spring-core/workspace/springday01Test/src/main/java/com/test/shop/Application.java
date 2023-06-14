package com.test.shop;

import com.test.common.ProdDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
    ApplicationContext context=new AnnotationConfigApplicationContext(Contextconfiguration.class);
    //설정 페이지 위임
        String[] beanNames=context.getBeanDefinitionNames();
        for(String beanName:beanNames){
            System.out.println("beanName = " + beanName);
        }

        ProdDAO prodDAO=context.getBean("prodDAO", ProdDAO.class);

        Scanner sc=new Scanner(System.in);
        String name;
        String info;
        int price;
        while(true){
        System.out.println("원하는 기능 번호를 선택하세요  1.구매 2.삼품등록 3.상품삭제 4.조회 5.전체 조회 6.나가기");
        int select=sc.nextInt();
        if(select==1){
            System.out.println("구매하려는 상품의 이름을 입력하세요");
            name=sc.nextLine();
            System.out.println("지불할 금액을 입력하세요");
            int money= sc.nextInt();
            prodDAO.send(name,money);
        }else if(select==2){
            System.out.println("상품 이름을 등록하세요 : " );
             name=sc.nextLine();
            System.out.println("상품 정보를 입력하세요 :");
            info=sc.nextLine();
            System.out.println("가격을 입력하세요 :");
            price= sc.nextInt();
            prodDAO.addProd(name,info,price);
        }else if(select==3){
            System.out.println("제거 하려는 상품 이름을 입력하세요 :");
            name=sc.nextLine();
            prodDAO.delete(name);
        }else if(select==4){
            System.out.println("찾으려는 상품 이름을 입력하세요 :" );
            name=sc.nextLine();
            prodDAO.findProd(name);
        }else if(select==5){
            prodDAO.allFindProd();
        }else{
            break;
        }
    }}

}
