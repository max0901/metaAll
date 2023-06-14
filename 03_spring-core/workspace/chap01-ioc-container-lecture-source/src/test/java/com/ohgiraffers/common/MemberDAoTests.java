package com.ohgiraffers.common;

import com.ohgiraffers.section03.subsection01.java.ContextConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {ContextConfiguration.class})
//세팅후 import
public class MemberDAoTests {

    @Autowired
    //가지고 있는 빈중에 같은 타입을 가져와라
    private MemberDAO memberDAO;
    @Test
    public void testCreateMemberDAO(){
        assertNotNull(memberDAO);
    }

    @Test
    public void testFindMemberBySequence(){
        //givn
        int sequence=1;

        //when
//        MemberDAO memberDAO=new MemberDAO();
        Member foundMember=memberDAO.findMenberBySequence(sequence);

        //then
        assertEquals("홍길동",foundMember.getName());
    }
@Test
    public  void testSave(){
        //givn
    Member member= new Member(3,"user03","pass03","유관순");

    //when
    boolean result=memberDAO.save(member);
    //then
    assertTrue(result);
    }
}
