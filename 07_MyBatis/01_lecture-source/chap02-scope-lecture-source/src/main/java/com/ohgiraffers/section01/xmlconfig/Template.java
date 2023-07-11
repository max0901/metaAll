package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSession getSqlSession(){

        if(sqlSessionFactory==null){
            //첫번쨰는 session이만들어 지지않았으므로 생성하고 다음부터는 만들지 않게하기 위해서 if문을 씀
            String resource="mybatis-config.xml";
            try {
                InputStream inputStream= Resources.getResourceAsStream(resource);
                sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        SqlSession sqlSession=sqlSessionFactory.openSession(false);
        System.out.println(sqlSessionFactory.hashCode());
        System.out.println(sqlSession.hashCode());
        return sqlSession;
    }
}
