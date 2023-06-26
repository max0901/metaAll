package com.test.domain.service;

import org.springframework.stereotype.Service;

@Service
public class DomainSellService {

    public boolean checkMoney(int money,int price){
    return money>price;
    }
    public int calculatorSell(int money,int price){
return money-price;
    }
}
