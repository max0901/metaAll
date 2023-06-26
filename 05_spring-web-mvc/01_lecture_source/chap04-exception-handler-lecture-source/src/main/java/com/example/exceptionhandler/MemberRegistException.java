package com.example.exceptionhandler;

public class MemberRegistException extends Exception{
    //exception을 상속받게되면 thorws 를 받아야한다
    public  MemberRegistException(){
        super();
    }
    public MemberRegistException(String msg){
        super(msg);
    }


}
