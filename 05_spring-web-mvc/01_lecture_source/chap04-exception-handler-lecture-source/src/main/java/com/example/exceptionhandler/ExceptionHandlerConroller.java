package com.example.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class ExceptionHandlerConroller {
    @GetMapping("simple-null")
    public String simpleNullPointerExceptionTest(){
        if(true){
            throw new RuntimeException();
        }
        String str=null;
        System.out.println("str.charAt(0) = " + str.charAt(0));
        return "/";
    }
    @GetMapping("simple-user")
    public String simpleUserExceptionTest() throws MemberRegistException{
        if(true){
            throw new MemberRegistException("회원으로 받을수 없습니다");
        }
        return "/";
    }
    @GetMapping("annotation-null")
    public String annotationNullPoineterExceptionTest(){

        String str=null;
        System.out.println("str.charAt(0) = " + str.charAt(0));

        return "/";
    }
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(){

        System.out.println("여기 핸들러로 오는데 맞는지 확인");
        return "error/nullPointer";
    }

    @GetMapping("annotation-user")
    public String annotationUserExceptionTest() throws MemberRegistException{
        if(true){
            throw new MemberRegistException("?????");
        }
        return "/";
    }
    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(Model model,MemberRegistException exception){
        model.addAttribute("exception",exception);
        return "error/memberRegist";
    }
}
