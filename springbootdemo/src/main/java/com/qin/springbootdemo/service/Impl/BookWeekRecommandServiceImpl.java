package com.qin.springbootdemo.service.Impl;


import com.qin.springbootdemo.dao.BookWeekRecommandMapper;
import com.qin.springbootdemo.domain.Book;
import com.qin.springbootdemo.service.BookWeekRecommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookWeekRecommandServiceImpl implements BookWeekRecommandService {

    @Autowired
    private BookWeekRecommandMapper bookWeekRecommandMapper;

    @Override
    public List<Book> findAllBook() {
        return bookWeekRecommandMapper.findAllBook();
    }

    @Override
    public List<Book> findBookByid(Integer id) {
        return bookWeekRecommandMapper.findBookByid(id);
    }
}
