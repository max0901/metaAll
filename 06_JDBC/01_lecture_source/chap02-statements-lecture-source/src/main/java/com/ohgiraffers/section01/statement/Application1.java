package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCtemplate.close;
import static com.ohgiraffers.common.JDBCtemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con=getConnection();

        Statement stmt=null;
        //데이터를 조회하기위해 statement이용

        ResultSet rset=null;
        //조회결과 집합자체를 ResultSet라고함

        try {
            stmt=con.createStatement();
           rset=stmt.executeQuery("SELECT EMP_ID,EMP_NAME FROM EMPLOYEE");
            //조회를하고 반환되어지는 데이터는 무조건 ResultSet에 담아야한다

            while(rset.next()){
                System.out.println(rset.getString("EMP_ID")+" "+rset.getString("EMP_NAME"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
