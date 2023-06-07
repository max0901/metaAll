package com.metamonkey;

import java.util.Scanner;

public class clamain {
    public static void main(String[] args) {
        divedCalculator divi=new divedCalculator();
        MinusCalculator minus=new MinusCalculator();
        Multiply mult=new Multiply();
        RemainderCalculator remain=new RemainderCalculator();
        Scanner sc=new Scanner(System.in);
        System.out.println("첫번쨰 정수를 입력하세요");
        int num1=sc.nextInt();
        System.out.println("두번쨰 정수를 입력하세요");
        int num2=sc.nextInt();
        System.out.println("+,-,/,*,% 중 하나를 입력해주세요");
        String str=sc.next();

        switch (str){
            case "+" : break;
            case "-" :
                System.out.println(minus.minusTwoNumbers(num1,num2));
                break;
            case "/" :
                System.out.println(divi.diviTwoNum(num1,num2));
                break;
            case "*" :
                System.out.println(mult.MultiplyTwoNumbers(num1,num2));
                break;
            case "%":
                System.out.println(remain.calRemainder(num1,num2));
                break;
        }
    }
}
