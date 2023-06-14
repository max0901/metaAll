package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.common.Poketmon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("fieldPrimary")
public class PoketmonBattleFiled {

    private Poketmon poketmon;

    @Autowired
    private PoketmonBattleFiled(Poketmon poketmon){
        this.poketmon=poketmon;
    }

    public void fight(){
        poketmon.attack();
    }
}
