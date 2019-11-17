package com.qin.springbootdemo.service.Impl;

import com.qin.springbootdemo.dao.RegisteredMapper;
import com.qin.springbootdemo.dao.UserMapper;
import com.qin.springbootdemo.domain.User;
import com.qin.springbootdemo.service.RegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/* author:Qinzijing
*  date: 2019/11/9
*  description:注册服务
*/
@Service
public class RegisteredServiceImpl implements RegisteredService {

    @Autowired
    private RegisteredMapper registeredMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer registedUser(User user) {

        /*
        * 检查有无注册重名的
        * */
        User userTwo = userMapper.loadUserByUsername(user.getUsername());
        if (userTwo != null)
            return -1;
        /*
        * 加密密码
        * */
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String encodePassword = encoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        /*
        * 注册失败
        * */
        Integer code = registeredMapper.registedUser(user);
        Integer userId = user.getUserId();
        if (code == null || code == 0)
            return 0;
         registeredMapper.insertUserRole(userId);
        return userId;
    }

    @Override
    public Integer registedAdmin(User admin) {

        User userTwo = userMapper.loadUserByUsername(admin.getUsername());
        if (userTwo != null)
            return -1;

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String encodePassword = encoder.encode(admin.getPassword());
        admin.setPassword(encodePassword);

        Integer code = registeredMapper.registedAdmin(admin);
        Integer userId = admin.getUserId();
        if (code == null || code == 0)
            return 0;
        registeredMapper.insertAdminRole(userId);

        return userId;
    }

}
