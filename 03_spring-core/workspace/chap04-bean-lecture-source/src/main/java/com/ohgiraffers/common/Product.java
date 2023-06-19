package com.ohgiraffers.common;

public abstract class Product {
    //abstract 로 추상클래스로 만들기

    private String name;
    private  int price;

    public Product(){

    }
    public Product(String name, int price){
        this.name=name;
        this.price=price;
    }

    @Override
    public String toString() {
        return  name+" "+price;
    }

    public void setName(String name) {
        this.name = name;
    }
public  void getName(String name){
        this.name=name;
}
    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
