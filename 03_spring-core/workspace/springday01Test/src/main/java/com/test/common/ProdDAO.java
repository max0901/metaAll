package com.test.common;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class ProdDAO {
private final Map<Integer, Prod> prodMap;

    public ProdDAO(){
        this.prodMap=new HashMap<>();
        this.prodMap.put(1,new Prod("사과","맛있고 상큼한 사과",3000));
        this.prodMap.put(2,new Prod("바나나","맛있고 달콤한 바나나",4000));
        this.prodMap.put(3,new Prod("수박","맛있고 시원한 수박",2000));

    }
    public void allFindProd(){
        System.out.println(prodMap);
    }
    public Prod findProd(String name){
        return prodMap.get(name);
    }
    public void addProd(String name,String info,int price){
        prodMap.put(prodMap.size()+1,new Prod(name,info,price));
        System.out.println(prodMap);
    }
    public  Prod delete(String name){
        return prodMap.remove(name);}
//    public void editProd(String name){
//        System.out.println(instansceof(prodMap.get(name)));;
//    }
    
    public void send(String name,int money){
        int price=prodMap.get(name).getPrice();
        if(price>money){
            System.out.println("구매실패");
        }else{
            System.out.println("구매성공");
        }
    }
    }
