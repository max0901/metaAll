package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

public interface Mapper {
    @Select("SELECT CURDATE() FROM DUAL")
    java.util.Date selectNow();
    // selectNow id값  과 조회결과를 date타입으로 반환하라는 명령문


}
