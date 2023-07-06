package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Application1 {
    public static void main(String[] args) {
        Connection con=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //오타가 발생하거나 driver가없을 떄 발생하는 예외

            con= DriverManager.getConnection("jdbc:mysql://localhost/employee","ohgiraffers","ohgiraffers");
            //localhost는 나의 컴퓨터에서 하는거고 다른 컴퓨터 db를 받으려면 localhost부분을 바꾼다

            System.out.println("con = " + con);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                //if 문 안에있는 조건이 위치가 바뀌면 앞쪽에서 nullpoint오류가 발생하게 된다
                //&& 연산자는 앞에 조건이 true경우에만 뒤에 조건을 확인하므로 조건 순서도 중요하다
                if(con!=null && !con.isClosed()){
                //connetion은 사용후 꼭 close를 해야한다
                    //connection이 null이라서 생성도 안됬는데 finally는 무조건 실행되므로 nullpointExcetion에러가 뜬다
                con.close();}
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
