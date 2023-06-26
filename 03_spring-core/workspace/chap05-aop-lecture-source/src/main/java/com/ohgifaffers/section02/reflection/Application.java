package com.ohgifaffers.section02.reflection;

import java.lang.reflect.*;

public class Application {
    public static void main(String[] args) {
        
        //인스턴스말고 클래스자료형 객체를 만드는방법
    Class class1= Account.class;
    //Accout에대한 모든것
        System.out.println("class1 = " + class1);
        //class자료형에서 toString으로 출력
        
        Class class2=new Account().getClass();
        System.out.println("class2 = " + class2);

        try {
            Class class3=Class.forName("com.ohgifaffers.section02.reflection.Account");
            System.out.println("class3 = " + class3);

            Class class4=Class.forName("[D");
            System.out.println("class4 = " + class4);

            Class class5=double[].class;
            System.out.println("class5 = " + class5);
            //class4는 class5처럼 이해할것

            Class class6=Class.forName("[Ljava.lang.String;");
            System.out.println("class6 = " + class6);

            Class class7=String[].class;
            System.out.println("class7 = " + class7);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //동적로딩 필요한시점에 로딩하기떄문에 로드 속도가빠르고 최초시점에 느리다
        //class3방법은 trycatch문사용
        
        
        Class class8= Double.TYPE;
        System.out.println("class8 = " + class8);
                //Double앞에 대문자이면 wrapper클래스라고한다
        
        Class class9=Void.TYPE;
        System.out.println("class9 = " + class9);
        
        //무엇을 할수있는지
        
        Class superClass=class1.getSuperclass();
        System.out.println("superClass = " + superClass);
        //슈퍼클래스로 class1을 만든다

       Field[] fields= Account.class.getDeclaredFields();
       for(Field field:fields){
           System.out.println("modifires : "+ Modifier.toString(field.getModifiers())+"type : "+field.getType()+
                   "name : "+ field.getName() );
       }
       //Account는 private로 선언하긴했지만 밖에서도 사용가능 은닉이안됨

        
       Constructor[] constructors= Account.class.getConstructors();

       for(Constructor con:constructors){
           System.out.println("name = " + con.getName());
           
         Class[] params=  con.getParameterTypes();
         for(Class param:params){
             System.out.println("param = " + param);
         }
       }
        try {
            Account acc=(Account) constructors[0].newInstance("20","110-232-1231","1234",10000);
            //trycatch문으로 묶고 실제타입으로 형변환해줘야함
            System.out.println("acc.getBalance() = " + acc.getBalance());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        Method[] methods= Account.class.getMethods();
        Method getBalanceMethod=null;
        for(Method method:methods){
            System.out.println(Modifier.toString(method.getModifiers())+" "+method.getReturnType().getSimpleName()+
                    " "+method.getName());

            if("getBalance".equals(method.getName())){
                getBalanceMethod=method;
            }
        }
        try {
            System.out.println(getBalanceMethod.invoke(constructors[2].newInstance()));
                //생성자를 이용해서 객체를 쉽게 만들고 사용 가능
            //invoke
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }


    }
    public void method(Class class1){}
}
