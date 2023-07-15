package com.controller;

import com.domain.Book;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
@ResponseBody
public class BookController {
    @Autowired//其实就是实现BookService bookService = new BookServiceImpl();的过程
    private BookService bookService;
    @PostMapping
    public Result save(@RequestBody Book book) {//从页面获得的json数据，记得使用@RequestBody
        boolean flag = bookService.save(book);
        if(flag) {
            return new Result(flag,Code.SAVE_OK);
        }
        else return new Result(flag, Code.SAVE_ERR);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        if(flag) {
            return new Result(flag,Code.DELETE_OK);
        }
        else return new Result(flag, Code.DELETE_ERR);
    }
    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        if(flag) {
            return new Result(flag,Code.UPDATE_OK);
        }
        else return new Result(flag, Code.UPDATE_ERR);
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code = book != null ? Code.GET_OK:Code.GET_ERR;
        String msg = book != null ? "查询成功":"查询失败";
        return new Result(book,code,msg);
    }
    @GetMapping
    public Result getAll() {
        List<Book> books = bookService.getAll();
        Integer code = books != null ? Code.GET_OK:Code.GET_ERR;
        String msg = books != null ? "查询成功":"查询失败";
        return new Result(books,code,msg);
    }
}
