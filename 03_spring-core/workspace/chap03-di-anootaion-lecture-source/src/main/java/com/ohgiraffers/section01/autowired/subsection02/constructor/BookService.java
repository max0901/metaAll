package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.autowired.common.Book;
import com.ohgiraffers.section01.autowired.common.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceConsutructor")
public class BookService {
//    @Autowired   //생성자가 하나만존재하는 경우 생략가능
    private final BookDAO bookDAO;

    public BookService(BookDAO bookDAO){
        this.bookDAO=bookDAO;
    }
    public List<Book> findAllBooks(){
        return bookDAO.findAllBooks();
    }

    public Book SerchBookBySequence(int sequence){
        return bookDAO.findBookBySequence(sequence);
    }
}
