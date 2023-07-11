package com.ohgiraffers.domain.entity;

public class Menu {
 private int menuConde;
 private String menuName;
 private int menuPrice;
 private int categoryCode;
 private String orderableStatus;

 public Menu(){}

    public Menu(int menuConde, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuConde = menuConde;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public Menu(String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuName=menuName;
        this.menuPrice=menuPrice;
        this.categoryCode=categoryCode;
        this.orderableStatus=orderableStatus;

    }

    public Menu(int menuCode, String menuName, int menuPrice) {
        this.menuConde=menuCode;
        this.menuName=menuName;
        this.menuPrice=menuPrice;

    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuConde=" + menuConde +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }

    public int getMenuConde() {
        return menuConde;
    }

    public void setMenuConde(int menuConde) {
        this.menuConde = menuConde;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }
}
