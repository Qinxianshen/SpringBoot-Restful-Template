package com.qin.springbootdemo.controller;


import com.qin.springbootdemo.service.BookWeekRecommandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/* author:Qinzijing
*  date: 2019/11/8
*  description:本周推荐
*/
@RestController
@RequestMapping("/api/book/v1.0/bookweekrecommand")
public class BookWeekRecommandController {

    @Resource
    public BookWeekRecommandService bookWeekRecommandService;

    @GetMapping("/findAllBook")
    public Map<String,Object> findAllBook(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",bookWeekRecommandService.findAllBook());
        map.put("msg","获取成功");
        map.put("code",200);
        return map;
    }

    @GetMapping("/findBookByid")
    public Map<String,Object> findBookByid(@RequestParam("id")Integer id){
        Map<String,Object> map = new HashMap<>();
        map.put("data",bookWeekRecommandService.findBookByid(id));
        map.put("msg","获取成功");
        map.put("code",200);
        return map;
    }

}
