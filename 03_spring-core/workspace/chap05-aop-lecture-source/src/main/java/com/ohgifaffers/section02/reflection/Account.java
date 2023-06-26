package com.ohgifaffers.section02.reflection;

public class Account {
    private String bankCode;
    private String accNo;
    private String accPwd;
    private int balance;


    public Account(){}
    public  Account(String bankCode,String accNo,String accPwd){
        this.accNo=accNo;
        this.accPwd=accPwd;
        this.bankCode=bankCode;
    }
    public Account(String bankCode,String accNo,String accPwd,int balance){
        this(bankCode,accNo,accPwd);
        this.balance=balance;

    }

    public String getBalance(){
        return this.accNo+"계좌의 잔액은 : "+this.balance+"원 입니다";
    }

    public String depeosit(int money){
        String str="금액을 잘못 입력하셧습니다";
        if(money >=0){
            this.balance+=money;
            return money +"원이 입금되었습니다";
        }
        return "금액을 잘못 입력 하셧습니다";
    }

    public String withdraw(int money){
        if(this.balance>=money){
            this.balance-=money;
            return money+"원이 출금되었습니다";
        }
        return "잔액이 부족합니다. 잔액을 확인해주세요.";
    }
}
