package com.ohgiraffers.section01.autowired.common;

import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository("bookDAO")
public class BookDAOImpl2 implements BookDAO{
    @Override
    public List<Book> findAllBooks() {
        return null;
    }

    @Override
    public Book findBookBySequence(int sequence) {
        return null;
    }
}
