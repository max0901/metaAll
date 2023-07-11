package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

public class MenuController {
    private final MenuService menuService;
    private  final PrintResult printResult;
    public MenuController(){
        printResult=new PrintResult();
        menuService=new MenuService();
    }

    public void findAllMenus() {
        List<MenuDTO> menus=menuService.findAllMenus();

        if(menus!=null){
            printResult.printMenus(menus);

        }else{
            printResult.printErrorMessage("findAllMenus");
        }
    }

    public void findMenuByMenuCode(Map<String, String> parmeter) {
        int menuCode=Integer.parseInt(parmeter.get("menuCode"));
        MenuDTO menu= menuService.findMenuByMenuCode(menuCode);

        if(menu!=null){
            printResult.printMenu(menu);

        }else {
            printResult.printErrorMessage("findMenuByMenuCode");
        }
    }

    public void registMenu(Map<String, String> parameter) {

        String menuName=parameter.get("menuName");
        int menuPrice=Integer.parseInt(parameter.get("menuPrice"));
        int categoryCode=Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu=new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);

        if(menuService.registMenu(menu)){
            printResult.printSuccessMessage("regist");
        }else{
            printResult.printErrorMessage("regist");
        }
    }

    public void modifyMenu(Map<String, String> parmeter) {
       int menuCode=Integer.parseInt(parmeter.get("menuCode"));
        String changeMenuName=parmeter.get("menuName");
        int changeMenuPrice= Integer.parseInt(parmeter.get("menuPrice"));

        MenuDTO menu=new MenuDTO();
        menu.setMenuCode(menuCode);
        menu.setMenuName(changeMenuName);
        menu.setMenuPrice(changeMenuPrice);

        if(menuService.modifyMenu(menu)){
            printResult.printSuccessMessage("modify");

        }else{
            printResult.printErrorMessage("modify");
        }
    }

    public void removeMenu(Map<String, String> parmeter) {
        int menuCode=Integer.parseInt(parmeter.get("menuCode"));
        if(menuService.removeMenu(menuCode)){
            printResult.printSuccessMessage("remove");
        }else{
            printResult.printErrorMessage("remove");
        }
    }
}
