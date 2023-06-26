package com.ohgifaffers.section03.proxy.subsection01.dynamic;

import com.ohgifaffers.section03.proxy.common.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    private final Student student;
    public  Handler(Student student){
        this.student=student;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("+========== 공부 시작=======");
        method.invoke(student,args);
        System.out.println(method);
        for(Object arg:args){
            System.out.println(args);
        }
        System.out.println("+========== 공부 끝======");
        return proxy;
        //proxy를 return을해줘야 잠깐 들렸다 통과하는 것 처럼 보임
    }
}
