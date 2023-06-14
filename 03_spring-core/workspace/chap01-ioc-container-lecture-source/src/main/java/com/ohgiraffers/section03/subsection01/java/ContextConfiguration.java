package com.ohgiraffers.section03.subsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ohgiraffers"})
// 기능 활성 ,포함되있는 패키지를 스캔하여 componenet가 있는곳에 객체를 가져옴 basepackages를 통해 원하는 패키지도 스캔가능
public class ContextConfiguration {
}
