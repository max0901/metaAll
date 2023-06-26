package com.example.interceptor;

import org.springframework.stereotype.Service;

@Service
public class MenuService {
    public void method(){
        System.out.println("service메소드호출");
    }
}
