package com.ohgiraffers.section02.initdestory.subsection02.annotation;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@ComponentScan("com.ohgiraffers.section02.initdestory.subsection02.annotation")
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

}