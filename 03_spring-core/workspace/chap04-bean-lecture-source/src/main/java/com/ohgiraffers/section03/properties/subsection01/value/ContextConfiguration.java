package com.ohgiraffers.section03.properties.subsection01.value;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("section03/properties/subsectuon01/value/product-info.properties")
public class ContextConfiguration {
    @Value("${bread.carpbread.name}")
    private String carpBreadName;
    @Value("${bread.carpbread.price}")
    private  int carpBreadPrice;

    @Value("${bread.carpbead.name:팥붕어빵}")
    private  String carpBreadName2;

    @Value("${beverage.milk.name:}")
    private String milkName;
    @Value("${beverage.milk.price:0}")
    private int milkPrice;
     @Value("${beverage.milk.capacity:0}")
    private int milkCapacity;

    @Bean("milk")
    public Product carpBread(){
        return  new Beverage(milkName,milkPrice,milkCapacity);
    }
    @Bean //매개변수로 받을때 안에 @Value를써서 사용한다
    public Product water(@Value("${beverage.water.name}") String waterName,
                         @Value("${beverage.water.price:0}")int waterPrice,
                         @Value("${beverage.water.capacity:0}")int waterCapacity){
        return new Beverage(waterName,waterPrice,waterCapacity);
    }

}
