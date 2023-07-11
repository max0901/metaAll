package com.ohgiraffers.section01.insert;

import java.sql.*;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application01 {
    public static void main(String[] args) {
        //CRUD 연산
        //C(insert) : Create
        //R(select) : Read
        //U(update) : Update
        //D(delete) : Delete
        Connection con=getConnection();
        PreparedStatement pstmt=null;
        int result=0;
        // 반환을 정수로 받는다s
        String query="INSERT INTO TBL_MENU (MENU_NAME,MENU_PRICE,CATEGORY_CODE,ORDERABLE_STATUS)"+ "VALUES(?,?,?,?)";

        try {
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,"봉골레");
            pstmt.setInt(2,20000);
            pstmt.setInt(3,4);
            pstmt.setString(4,"Y");

            result= pstmt.executeUpdate();

            if(result>0){
                con.commit();
                //commit이 실행되야 db에적용된다 그전에는 메모리에만 저장된다
                //JDBCTemplete에서 setAutoCommit을 false로 두었기 때문에 자동 commit이 되지 않는다
            }else{
                con.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            close(pstmt);
            close(con);
        }
        System.out.println("result = " + result);


    }
}
