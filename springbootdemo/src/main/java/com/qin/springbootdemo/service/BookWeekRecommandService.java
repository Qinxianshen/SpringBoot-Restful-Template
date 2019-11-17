package com.qin.springbootdemo.service;


import com.qin.springbootdemo.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookWeekRecommandService {
    List<Book> findAllBook();
    List<Book> findBookByid(Integer id);
}
