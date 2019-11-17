package com.qin.springbootdemo.controller;

import com.qin.springbootdemo.service.BookDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/* author:Qinzijing
*  date: 2019/11/13
*  description:书籍详情控制器
*/
@RestController
@RequestMapping("/api/book/v1.0/bookDetails")
public class BookDetailsController {

    @Resource
    public BookDetailsService bookDetailsService;

    @GetMapping("/findBookDetailsById")
    public Map<String,Object> findBookById(Integer bookId){
        Map<String,Object> map = new HashMap<>();
        map.put("data",bookDetailsService.findBookById(bookId));
        map.put("msg","获取成功");
        map.put("code",200);
        return map;
    }

    @GetMapping("/findBookByClassName")
    public Map<String,Object> selectBookByClass(String bookClassName){
        Map<String,Object> map = new HashMap<>();
        map.put("data",bookDetailsService.selectBookByClass(bookClassName));
        map.put("msg","获取成功");
        map.put("code",200);
        return map;
    }

}
