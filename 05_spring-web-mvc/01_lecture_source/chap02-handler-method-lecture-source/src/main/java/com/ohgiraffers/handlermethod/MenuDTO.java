package com.ohgiraffers.handlermethod;

public class MenuDTO {

    private String name;
    private int price;
    private int categoryCode;
    private  String ordertableStatus;

    public MenuDTO() {
    }

    public MenuDTO(String name, int price, int categoryCode, String ordertableStatus) {
        this.name = name;
        this.price = price;
        this.categoryCode = categoryCode;
        this.ordertableStatus = ordertableStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + ordertableStatus + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrdertableStatus() {
        return ordertableStatus;
    }

    public void setOrdertableStatus(String orderableStatus) {
        this.ordertableStatus = orderableStatus;
    }
}
