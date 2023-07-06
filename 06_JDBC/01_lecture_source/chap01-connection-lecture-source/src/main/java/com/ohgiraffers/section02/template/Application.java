package com.ohgiraffers.section02.template;

import java.sql.Connection;
import java.sql.SQLException;

import static com.ohgiraffers.section02.template.JDBCtemplate.close;
import static com.ohgiraffers.section02.template.JDBCtemplate.getConnection;

public class Application {
    public static void main(String[] args) {
        Connection con=getConnection();
        //이름만쓸때는 import를 따로 해줘야함
        System.out.println("con = " + con);

     close(con);
    }
}
