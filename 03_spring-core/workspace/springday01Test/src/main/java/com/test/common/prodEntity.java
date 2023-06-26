package com.test.common;

public class prodEntity {
    private int prodSequence;
    private String name;
private int price;
    public prodEntity(int prodSequence,String name,int price){
        this.prodSequence=prodSequence;
        this.name=name;
        this.price=price;
    }

    public Integer getSequence(int sequnce){
        return this.prodSequence=sequnce;

    }
}
