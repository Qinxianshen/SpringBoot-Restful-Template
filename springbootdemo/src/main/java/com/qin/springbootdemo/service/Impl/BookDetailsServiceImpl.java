package com.qin.springbootdemo.service.Impl;

import com.qin.springbootdemo.dao.BookMapper;
import com.qin.springbootdemo.domain.Book;
import com.qin.springbootdemo.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/* author:Qinzijing
*  date: 2019/11/13
*  description:书籍详情
*/
@Service
public class BookDetailsServiceImpl implements BookDetailsService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book findBookById(Integer bookId) {
        return bookMapper.findBookByid(bookId);
    }

    @Override
    public List<Book> selectBookByClass(String bookClassName) {
        return bookMapper.selectBookByClass(bookClassName);
    }
}
