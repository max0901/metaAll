package com.ohgiraffers.common;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BeverageDAO {
private final Map<Integer,Beverage> beverageMap;

  public BeverageDAO(){
      this.beverageMap=new HashMap<>();
      this.beverageMap.put(1,new Beverage(1,"사이다",4000));
      this.beverageMap.put(2,new Beverage(2,"콜라",3000));
      this.beverageMap.put(3,new Beverage(3,"밀키스",2000));

  }

  public  Beverage findProdNum(int prodNum){
      return beverageMap.get(prodNum);

  }
  public boolean save(Beverage beverage){
      int before=beverageMap.size();
      beverageMap.put(beverage.getProdNum(),beverage);
      int after=beverageMap.size();

      return after>before?true:false;
  }

  public void Caculator(int money,int price){
        if(money>price){
            int result=money-price;
            System.out.println("잔돈은"+result+"입니다");
        }else{
           throw new IllegalArgumentException("구매실패");
        }

  }
  public void addBeverage(String name,int price){
      this.beverageMap.put(beverageMap.size()+1,new Beverage(beverageMap.size()+1,name,price));
      System.out.println(beverageMap);
  }
}
