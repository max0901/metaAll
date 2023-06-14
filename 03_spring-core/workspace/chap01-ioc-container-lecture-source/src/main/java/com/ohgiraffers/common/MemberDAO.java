package com.ohgiraffers.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
//@Component
//@Service
//@Controller
@Repository
//각 계층에 맞게 써야하고 정확하지않을때는 component사용
public class MemberDAO {
    private final Map<Integer,Member> memberMap;

    public MemberDAO(){ //회원 추가로직
        this.memberMap=new HashMap<>();
        this.memberMap.put(1,new Member(1,"user01","pass01","홍길동"));
        this.memberMap.put(2,new Member(2,"user02","pass02","유관순"));
    }

    public Member findMenberBySequence(int sequence){ //회원 찾는로직
        return  memberMap.get(sequence);
    }

    public  boolean save(Member member){ //회원이 추가되었는지 확인하는 로직
        int before=memberMap.size();
        memberMap.put(member.getSequence(),member);
        int after=memberMap.size();

        return after>before? true:false;
    }
    public void addMember(String id,String pwd,String name){
        this.memberMap.put(memberMap.size()+1,new Member(memberMap.size()+1,id,pwd,name ));


    }

}
