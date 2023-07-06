package com.ohgiraffers.section02.template;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCtemplate {

    public static Connection getConnection(){
        Connection con= null;

        Properties props=new Properties();

        try {
            props.load(new FileReader("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));

            String driver=props.getProperty("driver");
            String url=props.getProperty("url");

            Class.forName(driver);
            con= DriverManager.getConnection(url,props);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //template에서는 생성만 목적으로하고있기떄문에 따로 close를 하지 않는다
        return con;
    }

    public static void close(Connection con){
        try {
            if(con!=null&&con.isClosed()){
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
