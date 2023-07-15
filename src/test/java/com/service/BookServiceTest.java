package com.service;

import com.config.SpringConfig;
import com.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class) //整合的junit测试
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Test
    public void testGetById() {
        Book book = bookService.getById(2);
        System.out.println(book);
    }
    @Test
    public void testGetAll() {
        List<Book> books = bookService.getAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }
    @Test
    public void testSave() {
        Book book = new Book(6,"明朝那些事","小说","好书");
        if(bookService.save(book)) {
            System.out.println("true");
        }
        else System.out.println("false");
    }
    @Test
    public void testDelete() {
        if(bookService.delete(6)) {
            System.out.println("true");
        }
        else System.out.println("false");
    }
}
