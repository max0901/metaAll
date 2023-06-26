package com.ohgifaffers.section03.proxy.subsection02.cglib;

import com.ohgifaffers.section03.proxy.common.OhgiraffersStudent;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class Handler implements InvocationHandler {
    private final OhgiraffersStudent student;
    public Handler(OhgiraffersStudent student){
        this.student=student;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("=======공부 시작2========");

        method.invoke(student,args);
        System.out.println(method);

        System.out.println("=======공부 끝2========");
        return proxy;
    }
}
