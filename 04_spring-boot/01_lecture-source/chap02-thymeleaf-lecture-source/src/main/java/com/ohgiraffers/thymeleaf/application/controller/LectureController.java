package com.ohgiraffers.thymeleaf.application.controller;

import com.ohgiraffers.thymeleaf.application.dto.MemberDTO;
import com.ohgiraffers.thymeleaf.application.dto.SelectCriterla;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("lecture")
//GetMapping이여러개일떄 겹치는 부분 설정 그럼 밑에는 안써도된다
public class LectureController {
    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv){
        mv.addObject("hello","<h3>hi</h3>");
        //글자 추가
        mv.setViewName("/lecture/expression");
        //확장자와 앞에 resources/teplates 생력한다
        mv.addObject("member",new MemberDTO("홍길동",20,'남',"서울시"));
        return mv;
    }
    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv){

        mv.addObject("num",1);
        mv.addObject("str","나나");

        List<MemberDTO> members=new ArrayList<>();
        members.add(new MemberDTO("홍길동",20,'남',"서초구"));
        members.add(new MemberDTO("유관순",25,'여',"송파구"));
        members.add(new MemberDTO("장보고",30,'남',"수정구"));
        members.add(new MemberDTO("신사임당",21,'여',"분당"));

        mv.addObject("members",members);

        return mv;
    }
    @GetMapping("etc")
    public ModelAndView etc(ModelAndView mv){
        SelectCriterla selectCriterla=new SelectCriterla(1,10,3);
        mv.addObject(selectCriterla);
        //키값과 밸류값 이름이 같아진다
        return mv;
    }
}
