package com.qin.springbootdemo.service.Impl;

import com.qin.springbootdemo.dao.UserMapper;
import com.qin.springbootdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/* author:Qinzijing
*  date: 2019/11/10
*  description:登陆业务层实现
*/
@Service
public class LoginServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("账号不存在");
        }
        user.setRoles(userMapper.getUserRolesByUid(user.getUserId()));
        return user;
    }
}
