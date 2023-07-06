package com.ohgiraffers.section01.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application2 {
    public static void main(String[] args) {

        Properties prop=new Properties();
        Connection con=null;
        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));
            //properties파일 연결
            System.out.println("prop = " + prop);

            String driver=prop.getProperty("driver");
            String url=prop.getProperty("url");
            String user=prop.getProperty("user");
            String password=prop.getProperty("password");
            //안에있는 값들을 가져온다
            Class.forName(driver);

            con= DriverManager.getConnection(url,user,password);
            System.out.println("con = " + con);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
                try {
            if(con!=null&&!con.isClosed()){
                    con.close();
                }
                }
                catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

