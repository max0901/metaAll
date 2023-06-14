package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.autowired.common.Book;
import com.ohgiraffers.section01.autowired.common.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceField")
public class BookService {
    @Autowired //빈생성시 컨테이너안에 같은 타입인 객체가 있으면 가져와서 정보를 넣는다
    private  BookDAO bookDAO;
    public List<Book> findAllBooks(){
        return bookDAO.findAllBooks();
    };
    public Book SerachBookBySequence(int sequence){
        return bookDAO.findBookBySequence(sequence);
    };
}
