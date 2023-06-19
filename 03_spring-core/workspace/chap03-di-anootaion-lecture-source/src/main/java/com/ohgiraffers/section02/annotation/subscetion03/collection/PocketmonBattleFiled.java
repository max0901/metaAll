package com.ohgiraffers.section02.annotation.subscetion03.collection;



import com.ohgiraffers.section02.annotation.subsection01.primary.PoketmonBattleFiled;
import com.ohgiraffers.section02.common.Poketmon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("fieldCollection")
public class PocketmonBattleFiled {
    private List<Poketmon> poketmons;

    @Autowired
    public PocketmonBattleFiled(List<Poketmon> poketmons){
        this.poketmons=poketmons;
    }
    public void fight(){

    }


}
