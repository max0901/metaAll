package com.ohgiraffers.section01.autowired.common;
import  java.util.List;
public interface BookDAO {
//    도서목록 조회
    List<Book> findAllBooks();
//    도서번호로 도서 조회
    Book findBookBySequence(int sequence);
}
