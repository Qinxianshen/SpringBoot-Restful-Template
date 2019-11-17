package com.qin.springbootdemo.service;


import com.qin.springbootdemo.domain.Book;

import java.util.List;

/* author:Qinzijing
*  date: 2019/11/17
*  description:书籍详情
*/
public interface BookDetailsService {

    Book findBookById(Integer bookId);

    List<Book> selectBookByClass(String bookClassName);
}
