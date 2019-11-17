package com.qin.springbootdemo.dao;

import com.qin.springbootdemo.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/* author:Qinzijing
 *  date: 2019/11/11
 *  description:对整个书库里的内容进行管理
 */
@Repository
public interface BookMapper {

    /*
     * 通过Book的id值来获取书的详情内容
     * */
    Book findBookByid(Integer bookId);

    /*
     * 根据Book Name模糊查询 书详情内容
     * */
    List<Book> selectBookByNameLike(String bookName);

    /*
     * 根据Book number 查询书详情
     * */
    List<Book> selectBookByNumberLike(Integer bookNumber);

    /*
    * 根据Book 类 推荐猜你喜欢
    * */
    List<Book> selectBookByClass(String bookClassName);


}
