package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCtemplate.close;
import static com.ohgiraffers.common.JDBCtemplate.getConnection;

public class Application02 {
    public static void main(String[] args) {
        Connection con=getConnection();
        PreparedStatement pstmt=null;
        ResultSet rset=null;

        Scanner sc=new Scanner(System.in);
        System.out.print("조회하실 사번을 입력하세요 : ");
        String empId=sc.nextLine();

        String query="SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID=?";
                //나중에 값이 들어가는 곳을 ?로 표기한다

        try {
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,empId);
            //들어갈곳 순서와, 값을 넣어주면된다
            rset=pstmt.executeQuery();

            if(rset.next()){
                System.out.println(rset.getString("EMP_ID")+", " + rset.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);
            close(con);
        }

    }
}
