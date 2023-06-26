package com.ohgiraffers.thymeleaf.application.dto;

public class MemberDTO {
    private String name;
    private int age;
    private char gender;
    private String address;
    public MemberDTO(String name,int age,char gender,String address){
        this.address=address;
        this.age=age;
        this.name=name;
        this.gender=gender;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }

    public MemberDTO(){}
}
