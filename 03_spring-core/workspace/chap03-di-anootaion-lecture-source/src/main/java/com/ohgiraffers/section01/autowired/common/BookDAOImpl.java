package com.ohgiraffers.section01.autowired.common;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository("bookDAO")
public class BookDAOImpl implements BookDAO{

    private final Map<Integer,Book> bookList;
    //필드값을 변경하지 못하기위해서 final을 쓴다
    //final을 쓰는 기준 다 모든 값에써보고 아니면 지우면 된다

    public BookDAOImpl(){
        this.bookList=new HashMap<>();
        bookList.put(1,new Book(1,1234,"자바의 정석","남궁석ㅇ","도우출판",new java.util.Date()));
        bookList.put(2,new Book(2,5165,"정석","남","도출판",new java.util.Date()));

    }
    @Override
    public List<Book> findAllBooks() {
        return new ArrayList<>(bookList.values());
        //맵타입인 bookList를 value만 받아와서 List타입으로 바꾼다
    }

    @Override
    public Book findBookBySequence(int sequence) {

        return bookList.get(sequence);
    }


}
