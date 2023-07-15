package com.dao;

import com.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {
    @Insert("insert into book(id,name,type,description) values(#{id},#{name},#{type},#{description})")
    void save(Book book);
    @Delete("delete from book where id = #{id}")
    void delete(Integer id);
    @Update("update book set id = #{id}, name = #{name}, type = #{type}, description = #{description} where id = #{id}")
    void update(Book book);
    @Select("select * from book where id = #{id}")
    Book getById(Integer id);
    @Select("select * from book")
    List<Book> getAll();
}
