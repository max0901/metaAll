package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class MainController {
    //페이지 시작부터 데이터를 받아와야할때 동적인페이지를 만들떄 templates에 index를 만듬
    @RequestMapping(value = {"/","/main"})
    public String main(){
        return "main";
    }
}
