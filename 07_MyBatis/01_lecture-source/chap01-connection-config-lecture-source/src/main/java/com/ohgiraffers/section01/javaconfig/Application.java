package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {

        //Connectinon 역활을하는게 mybatis에서는 sqlsession
        private static String driver="com.mysql.cj.jdbc.Driver";
        private static  String url="jdbc:mysql://localhost/menu";
    private  static  String user="ohgiraffers";
    private static String password="ohgiraffers";

    public static void main(String[] args) {

        /* 필기
        *   JdbcTransactionFactory : 수동 커밋
        *   ManagedTransactionFactory : 자동 커밋
        *   -------------------------------------
        *   pooledDataSource : ConnectionPool 사용
        *   unPooledDataSoruce: ConnectionPool 사용하지 않음
        * */
        Environment environment=new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver,url,user,password)
                //데이터베이스 접속에 관련된 환경 구성
        );

        Configuration configuration=new Configuration(environment);
        //환경 구성정보를 설정객체에 넣어준다
        configuration.addMapper(Mapper.class);


        /*필기
        *   sqlsessionfactory: sqlsession 객체를 생성하기 위한 팩토리 역활의 인터페이스
        *   sqlsessionFactoryBuilder: sqlsessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역활
        *   build(): 설정에 대한 정보를 담고있는 configuration타입의 객체 혹은 외부설정 파일과 연결된 steam을 매개변수로 전달하면
        *              sqlsessionfactory 인터페이스 타입의 객체를 변환하는 메소드
        * */
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(configuration);
        //sqlsessionfactorybuilder를 이용해서 설정객체를 넣어준다
        SqlSession sqlsession=sqlSessionFactory.openSession(false);
        // === Connction con =getConnection();
        //autoCommit을 false로 변경 그래야 commit을 수동으로 할 수있음

        Mapper mapper=sqlsession.getMapper(Mapper.class);
        java.util.Date date=mapper.selectNow();
        System.out.println("date = " + date);
        sqlsession.close();
    }
}
