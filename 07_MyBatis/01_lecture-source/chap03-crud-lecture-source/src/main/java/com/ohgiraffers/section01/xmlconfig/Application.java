package com.ohgiraffers.section01.xmlconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MenuController menuController=new MenuController();
        do{
            System.out.println("=====메뉴관리=========");
            System.out.println("1. 메뉴 전체 조회");
            System.out.println("2. 메뉴코드로 조회");
            System.out.println("3. 신규메뉴 추가");
            System.out.println("4. 메뉴 수정");
            System.out.println("5. 메뉴 삭제");
            System.out.println("메뉴 관리 번호를 입력하세요 : ");
            int no=sc.nextInt();
            switch (no){
                case 1:menuController.findAllMenus();
                            break;
                case 2: menuController.findMenuByMenuCode(inputMenuCode());
                break;
                case 3: menuController.registMenu(inputMenu());
                case 4:menuController.modifyMenu(inputModifyMenu());
                        break;
                case 5:
                    menuController.removeMenu(inputRemoveMenuCode());
                    break;
                default:
                System.out.println("잘못된 메뉴를 입력하셧습니다 ");
                break;
            }
        }while(true);
    }

    private static Map<String,String> inputRemoveMenuCode() {
        Scanner sc=new Scanner(System.in);
        System.out.println("삭제할 메뉴 코드를 입력하세요 : ");
        String menuCode=sc.nextLine();
        Map<String,String> parameter=new HashMap<>();
        parameter.put("menuCode",menuCode);
        return parameter;
    }


    private  static Map<String,String> inputMenuCode(){
        Scanner sc=new Scanner(System.in);
        System.out.println("메뉴 코드를 입력하세요 : ");
        String menuCode=sc.nextLine();

        Map<String,String> parameter=new HashMap<>();
        parameter.put("menuCode",menuCode);
        return parameter;
    }
    private static Map<String, String > inputMenu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("메뉴의 이름을 입력해주세요 : ");
        String menuName=sc.nextLine();
        System.out.println("메뉴 가격을 입력해주세요 : ");
        String menuPrice=sc.nextLine();
        System.out.println("카테고리 코드를 입력해주세요 : ");
        String categoryCode=sc.nextLine();

        Map<String,String> parameter=new HashMap<>();
        parameter.put("menuName",menuName);
        parameter.put("menuPrice",menuPrice);
        parameter.put("categoryCode",categoryCode);

        return parameter;
    }
    private static Map<String,String > inputModifyMenu() {
        Scanner sc=new Scanner(System.in);
        System.out.println("메뉴의 코드를 입력해주세요 : ");
        String menuCode=sc.nextLine();
        System.out.println("바꿀 메뉴의 이름을 입력해주세요 : ");
        String changeMenuName=sc.nextLine();
        System.out.println("바꿀 메뉴의 가격을 입력해주세요 : ");
        String changeMenuPrice=sc.nextLine();


        Map<String,String> parameter=new HashMap<>();
        parameter.put("menuCode",menuCode);
        parameter.put("menuName",changeMenuName);
        parameter.put("menuPrice",changeMenuPrice);

        return parameter;
    }
}
