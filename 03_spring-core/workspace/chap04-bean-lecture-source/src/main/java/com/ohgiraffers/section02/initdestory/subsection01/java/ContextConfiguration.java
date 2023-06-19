package com.ohgiraffers.section02.initdestory.subsection01.java;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Configuration
public class ContextConfiguration {

    @Bean
    public Product carpBread(){
        return  new Bread("붕어빵",2000,new java.util.Date());
    }
    @Bean
    public Product milk(){
        return new Beverage("딸기우유",1000,500);

    }
    @Bean
    public   Product water(){
        return  new Beverage("지라산 암반수",3000,500);

    }
    @Bean
    @Scope("prototype")
    public ShoppingCart cart(){
        return new ShoppingCart();
    }
@Bean(initMethod = "openShop",destroyMethod = "closeShop")
//초기화될때 openshop메소드실행 ,정지일떄 closeShop메소드실행
    public Owner owner(){
        return new Owner();
}
}
