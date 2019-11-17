package com.qin.springbootdemo.controller;


import com.qin.springbootdemo.domain.NokiaResult;
import com.qin.springbootdemo.domain.User;
import com.qin.springbootdemo.service.RegisteredService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/registered")
public class RegisteredController {

    @Resource
    public RegisteredService registeredService;

    @PostMapping("/forUser")
    public NokiaResult registeredUser(User user){
        Integer userId = registeredService.registedUser(user);
        if(userId == -1){
            NokiaResult nokiaResult = new NokiaResult(-1,"失败，已经有这个账号了");
            return nokiaResult;
        }
        if(userId == 0){
            NokiaResult nokiaResult = new NokiaResult(-1,"注册失败");
            return nokiaResult;
        }
        NokiaResult nokiaResult = new NokiaResult(200,"成功 "+"userId:"+userId);
        return nokiaResult;
    }

    @PostMapping("/forAdmin")
    public NokiaResult registeredAdmin(User admin){
        Integer userId = registeredService.registedAdmin(admin);
        if(userId == -1){
            NokiaResult nokiaResult = new NokiaResult(-1,"失败，已经有这个账号了");
            return nokiaResult;
        }
        if(userId == 0){
            NokiaResult nokiaResult = new NokiaResult(-1,"注册失败");
            return nokiaResult;
        }
        NokiaResult nokiaResult = new NokiaResult(200,"成功"+"userId:"+userId);
        return nokiaResult;
    }

}
