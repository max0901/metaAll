package com.ohgiraffers.requestmapping;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order")
public class ClassMappingTestController {
    @GetMapping("/regist")
    public String registOrder(Model model){
        model.addAttribute("message","Get방식의 주문등록용 핸들러 메소드 동작함...");
        return  "mappingResult";
    }
    @RequestMapping(value = {"modify","delete"},method= RequestMethod.POST)
    public String modifyAndDelete(Model model){
        model.addAttribute("message","POST 방식의 주문정보 수정과 삭제 공통처리용 핸들로 메소드 호출함..");
        return "mappingResult";
    }
    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(Model model,@PathVariable("orderNo") int orderNo){
//        index에서 경로로 정보를 넘기면 PathVariable로 정보를 받는다
        model.addAttribute("message",orderNo+ "번 주문에 대한 상세 조회용 핸들러메소드 호출함 ...");
        return "mappingResult";
    }
}
