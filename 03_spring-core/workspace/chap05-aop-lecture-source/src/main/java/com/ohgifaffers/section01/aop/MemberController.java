package com.ohgifaffers.section01.aop;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class MemberController {
    private MemberService memberService;
    private MemberController(MemberService memberService){
        this.memberService=memberService;
    }
    public List<MemberInfoResponseDTO> findAllMembers(){
        return  memberService.findAllMembers();
    }

    public MemberInfoResponseDTO findMemberById(Map<String ,String> parameter){
       Long id=Long.parseLong(parameter.get("id"));
        return  memberService.findMemberById(id);
    }
}
