package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//핸들러 메소드
@Controller
public class MethodMappingTestController {
    @RequestMapping("/menu/regist")
    public String registMenu(Model model){
        model.addAttribute("message","신규 메뉴 등록용 핸들러 메소드 호출함...");
        return "mappingResult";
    }
    @RequestMapping(value = "/menu/modifiy",method = RequestMethod.GET)
    public String modifyMenu(Model model){
        model.addAttribute("message","GET방식의 메뉴 수정용 핸들러 메소드 호출함 ...");
        return "mappingResult";
    }
    @GetMapping("/menu/delete")
    public String getDeleteMethod(Model model){
        model.addAttribute("message","GET 방식의 삭제용 핸들로 메소드 호출함..");
        return "mappingResult";
    }
    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model){
        model.addAttribute("message","Post 방식의 삭제용 핸들러 메소드 호출함");
        return "mappingResult";
    }

}
