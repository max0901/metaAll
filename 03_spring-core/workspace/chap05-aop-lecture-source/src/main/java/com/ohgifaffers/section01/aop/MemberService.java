package com.ohgifaffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private final MemberDAO memberDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO){
        this.memberDAO=memberDAO;
    }
    public List<MemberInfoResponseDTO> findAllMembers() {
        List<Member> members = memberDAO.findAllMembers();

        List<MemberInfoResponseDTO> memberDTOs=new ArrayList<>();
        for(Member member:members){
         MemberInfoResponseDTO dto=changeToDTO(member);
       memberDTOs.add(dto);
        }
        System.out.println("findAllMembers Service Method call ...");
        return memberDTOs;
    }

    public MemberInfoResponseDTO findMemberById(Long id){
        System.out.println("findById Service Method call ...");
       return changeToDTO(memberDAO.findMemberById(id));

    }

    private MemberInfoResponseDTO changeToDTO(Member member){
        MemberInfoResponseDTO dto=new MemberInfoResponseDTO();
        dto.setId(member.getId());
        dto.setName(member.getName());
        return dto;
    }
}
