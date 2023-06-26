package com.ohgiraffers.handlermethod;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/first")
@SessionAttributes("id")
public class FirstController {
    // /first/regist 요청이들어옴

    @GetMapping("/regist")
    public void regist(){

    }
    @PostMapping("/regist")
    public String registMenu(Model model, WebRequest request){
            String name= request.getParameter("name");
            int price= Integer.parseInt(request.getParameter("price"));
            int categoryCode=Integer.parseInt( request.getParameter("categoryCode"));

            String message=name+"을(를) 신규메뉴 목록의 " + categoryCode+"번 카테고리에 "+price+"원으로 등록하였습니다";
            model.addAttribute("message",message);
        return "first/messagePrinter";
    }

    @GetMapping("modify")
    public void modify(){

    }
    @PostMapping("modify")
    public String modifyMenu(Model model, @RequestParam(required = false,name="name") String modifyName,@RequestParam(defaultValue = "0") int modifyPrice){
       String message=modifyName+"메뉴의 가격을 "+ modifyPrice +"로 가격을 변경하였습니다";
       model.addAttribute("message",message);
       return "first/messagePrinter";
    }
    @GetMapping("modify2")
    public void modify2(){

    }
    @PostMapping("modify2")
    public String modifyMenu2(Model model,@RequestParam Map<String,String> parameter){
        String modifyName=parameter.get("modifyName2");
        int modifyPrice=Integer.parseInt(parameter.get("modifyPrice2"));
        String message="메뉴의 이름을 "+modifyName+"(으)로, 가격을" +modifyPrice+"원으로 변경하였습니다";
        model.addAttribute("message",message);
        return "first/messagePrinter";
    }
@GetMapping("serch")
    public void serch(){}
    @PostMapping("serch")
    public String serchMenu(@ModelAttribute("menu") MenuDTO menu){
        System.out.println("menu = " + menu);
        return "first/serchResult";
    }

    @GetMapping("login")
    public void login(){}
    @PostMapping("login1")
    public String sessionTest1(HttpSession session,@RequestParam String id){
            //HttpSession 과 websession의 이용 목적이 다르다
        session.setAttribute("id",id);
        return "first/loginResult";
    }
    @GetMapping("logout1")
    public String logoutTest1(HttpSession session){
        session.invalidate();
        //세션정보 무효
        return "first/loginResult";
        //원래 페이지로 이동
    }
    @PostMapping("login2")
    public String sessionTest2(Model model,@RequestParam String id){
        model.addAttribute("id",id);
        return "first/loginResult";
    }
    @GetMapping("logout2")
    public String logoutTest2(SessionStatus sessionStatus){

        sessionStatus.setComplete();
        return "first/loginResult";
    }

    @GetMapping("body")
    public void body(){}
    @PostMapping("body")
    public void bodyTest(@RequestBody String body,@RequestHeader("content-type") String contentType,
                         @CookieValue(value="JSESSIONID",required=false) String sessionId){
        System.out.println("contentType = " + contentType);
        System.out.println("body = " + body);
        System.out.println("sessionId = " + sessionId);
    }
}
