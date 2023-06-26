package com.ohgifaffers.section03.proxy.common;
@FunctionalInterface
//안에 여러가지 메소드를 넣지못함 , 람다식을 만들기위해 쓰는것
public interface Student {
    //인터페이스는 완성형 메소드를 만들수없음
   public abstract void study(int hour);
   //인터페이스에는 public  추상메소드에는 abstract

    public default void method(){
        //default 메소드를 쓰면 interface에서 완성된 메소드를 사용가능
    }
}
