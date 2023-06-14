package com.ohgiraffers.common;

import com.ohgiraffers.beverage.ContextConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(classes = {ContextConfiguration.class})
public class BeverageTest {
    @Autowired
   private BeverageDAO beverageDAO;

    @Test
    public void testFindBeverage(){
        //given
        int prodNum=1;
        //when
        Beverage fondBeverage=beverageDAO.findProdNum(prodNum);
        //then
        assertEquals("사이다",fondBeverage.getName());

    }
    @Test
    public void testCalculator(){
        //given
        int money=5000;
        int price=3000;
        //when
//        Beverage beverageCalculator=beverageDAO.Caculator(money,price);
        //then

    }

}
