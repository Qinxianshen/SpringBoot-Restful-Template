package com.qin.springbootdemo.dao;

import com.qin.springbootdemo.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/* author:Qinzijing
*  date: 2019/11/8
*  description:获取本周推荐
*/
@Repository
public interface BookWeekRecommandMapper {
    List<Book> findAllBook();
    List<Book> findBookByid(Integer id);
}
