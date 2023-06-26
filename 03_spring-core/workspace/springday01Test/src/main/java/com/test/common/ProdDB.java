package com.test.common;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProdDB {
    private final Map<Integer,prodEntity> prodList;
    public ProdDB(){
    this.prodList=new HashMap<>();
   this.prodList.put(1,new prodEntity(1,"김",3000));
   this.prodList.put(2,new prodEntity(2,"김치",1000));
   this.prodList.put(3,new prodEntity(3,"밥",5000));
    }

    public List<prodEntity> findAllProd(){
        return new ArrayList<>(prodList.values());
    }
    public prodEntity findBySequece(int sequence){
        return prodList.get(sequence);
    }
}
