package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class PrintResult {
    public void printMenus(List<MenuDTO> menus) {

        menus.forEach(System.out::println);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage="";
        switch (errorCode){
            case "findAllMenus": errorMessage="메뉴 목록조회를 실패하였습니다";
            break;
            case "findMenuByMenuCode" :
                errorMessage = "메뉴 상세 조회에 실패 하였습니다";
                break;
            case  "regist":
                errorMessage="신규 메뉴 추가에 실패하셧습니다";
                break;
            case "modify" :
                errorMessage="메뉴바꾸기에 실패하였습니다";
            case "remove" :
                errorMessage="메뉴 삭제 실패";
            default:errorMessage="알 수 없는 에러 발생!";
                break;
        }
        System.out.println(errorMessage);
    }

    public void printMenu(MenuDTO menu) {
        System.out.println("menu = " + menu);
    }

    public void printSuccessMessage(String successCode) {
        String successMessage="";
        switch (successCode){
            case "regist":
                successMessage="신규 메뉴 등록에 성공 하셨습니다";
                break;
            case "modify":
                successMessage="메뉴 변경이 성공하였습니다";
            case "remove" :
                successMessage="메뉴 삭제 성공";
        }
        System.out.println(successMessage);
    }
}
