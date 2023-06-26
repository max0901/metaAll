package com.ohgifaffers.section03.proxy.common;

public class OhgiraffersStudent implements Student {

    @Override
    public void study(int hour) {
        System.out.println(hour+" 시간 만큼 공부한다");
    }

}
