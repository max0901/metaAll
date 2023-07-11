package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCtemplate.close;
import static com.ohgiraffers.common.JDBCtemplate.getConnection;

public class Application01 {
    public static void main(String[] args) {
        Connection con=getConnection();

        PreparedStatement prstmt=null;

        ResultSet rset=null;

        try {
            prstmt=con.prepareStatement("SELECT EMP_ID,EMP_NAME FROM EMPLYOEE");
            rset=prstmt.executeQuery();

            while (rset.next()){
                System.out.println(rset.getString("EMP_ID")+", "+rset.getString("EMP_NAME"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(prstmt);
            close(con);
        }

        }
    }

