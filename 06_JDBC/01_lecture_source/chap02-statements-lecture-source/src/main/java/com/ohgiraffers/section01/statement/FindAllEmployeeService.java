package com.ohgiraffers.section01.statement;

import com.ohgiraffers.domain.entity.Employee;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.common.JDBCtemplate.close;
import static com.ohgiraffers.common.JDBCtemplate.getConnection;

public class FindAllEmployeeService {
    public List<Employee> findAllEmployss(){
            Connection con=getConnection();
            EmployeeRepository repository=new EmployeeRepository();
           List<Employee> employees= repository.findAllEmployss(con);

            close(con);
       return employees;
    }
    public List<Employee> findAllEmployss(String order){

            Connection con=getConnection();
            EmployeeRepository repository=new EmployeeRepository();
           List<Employee> employees= repository.findAllEmployss(con,order);

            close(con);
       return employees;
    }
}
