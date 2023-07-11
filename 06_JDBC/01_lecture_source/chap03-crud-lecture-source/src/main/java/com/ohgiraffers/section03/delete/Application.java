package com.ohgiraffers.section03.delete;

import com.ohgiraffers.domain.entity.Menu;
import com.ohgiraffers.section01.insert.MenuRegistService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application {
    public static void main(String[] args) {
        Connection con=getConnection();
        PreparedStatement pstmt=null;
        int result=0;
        //soft delete
      String query1="UPDATE TBL_MENU SET ORDERABLE_STATUS='N' WHERE MENU_CODE=?";
      //hard delete
      String query2="DELETE FROM TBL_MENU WHERE MENU_CODE=?";

        try {
            pstmt=con.prepareStatement(query2);
             pstmt.setInt (1,24);
            result=pstmt.executeUpdate();
            if(result>0){
                commit(con);
            }else {
                rollback(con);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
            close(con);
        }
        System.out.println("result = " + result);
    }
}
