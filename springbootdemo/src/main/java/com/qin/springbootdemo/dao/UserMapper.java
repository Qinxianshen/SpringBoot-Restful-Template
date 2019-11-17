package com.qin.springbootdemo.dao;

import com.qin.springbootdemo.domain.Role;
import com.qin.springbootdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/* author:Qinzijing
 *  date: 2019/11/10
 *  description: 获取用户信息的接口
 */
@Repository
public interface UserMapper {
    User loadUserByUsername(String username);
    List<Role> getUserRolesByUid(Integer id);
}
