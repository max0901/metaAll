package com.ohgiraffers.section01.autowired.subsection02.constructor;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext("com.ohgiraffers.section01");
        BookService bookService=context.getBean("bookServiceConsutructor",BookService.class);

        bookService.findAllBooks().stream().forEach((book -> {System.out.println(book);}));

        System.out.println(bookService.SerchBookBySequence(1));
    }
}
