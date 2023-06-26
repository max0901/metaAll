package com.ohgiraffers.thymeleaf.application.dto;

public class SelectCriterla {
    private int startPage;
    private int endPage;
    private int pageNo;

    public SelectCriterla(){};

    public SelectCriterla(int startPage, int endPage, int pageNo) {
        this.startPage = startPage;
        this.endPage = endPage;
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "SelectCriterla{" +
                "startPage=" + startPage +
                ", endPage=" + endPage +
                ", pageNo=" + pageNo +
                '}';
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getPageNo() {
        return pageNo;
    }
}
