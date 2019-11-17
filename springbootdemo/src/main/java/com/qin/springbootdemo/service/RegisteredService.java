package com.qin.springbootdemo.service;

import com.qin.springbootdemo.domain.User;
import org.springframework.stereotype.Service;

/* author:Qinzijing
*  date: 2019/11/9
*  description:注册服务
*/
@Service
public interface RegisteredService {

    Integer registedUser(User user);

    Integer registedAdmin(User admin);

}
