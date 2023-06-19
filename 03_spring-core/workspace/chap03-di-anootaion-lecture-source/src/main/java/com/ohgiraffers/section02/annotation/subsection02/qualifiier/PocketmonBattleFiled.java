package com.ohgiraffers.section02.annotation.subsection02.qualifiier;


import com.ohgiraffers.section02.common.Poketmon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fieldQualifier")
public class PocketmonBattleFiled {
    @Autowired
    @Qualifier("squirtle")
    //qualitifier는 네임을 부여한다
//    private Pocketmon poketmon;
    private Poketmon poketmon;
//    @Autowired
//    public PoketmonBattleFiled(Poketmon poketmon){
//        this.poketmon=poketmon;
//    }

    public void fight(){
        poketmon.attack();
    }

}
