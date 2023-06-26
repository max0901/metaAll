package com.example.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StopWatchInterceptor implements HandlerInterceptor {

    private final MenuService menuService;
    @Autowired
    public StopWatchInterceptor(MenuService menuService){
        this.menuService=menuService;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("prehandle 호출..");
        long startTime=System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
        //true 이어서 handler메소드 호출
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime=(Long) request.getAttribute("startTime");
        long endTime=System.currentTimeMillis();

        request.removeAttribute("startTime");
        modelAndView.addObject("interval",endTime-startTime);
        System.out.println("posthadle호출...");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        menuService.method();
        System.out.println("aftercompletion호출..");

    }
}
