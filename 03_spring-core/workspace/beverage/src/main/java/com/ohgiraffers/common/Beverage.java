package com.ohgiraffers.common;

import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Beverage {
    private int prodNum;
    private String name;
    private  int price;
}
