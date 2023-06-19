package com.ohgiraffers.common;

import java.util.Date;

public class Bread extends Product{
    private java.util.Date bakedDate;

    public Bread(){
//        super();
    }
    public Bread(String name,int price,java.util.Date bakedDate)
    {
        super(name,price);
        this.bakedDate=bakedDate;
    }


    @Override
    public String toString() {
        return bakedDate+" ";
    }

    public void setBakedDate(Date bakedDate) {
        this.bakedDate = bakedDate;
    }

    public Date getBakedDate() {
        return bakedDate;
    }
}
