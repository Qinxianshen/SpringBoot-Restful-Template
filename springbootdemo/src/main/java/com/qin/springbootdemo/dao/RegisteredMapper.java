package com.qin.springbootdemo.dao;

import com.qin.springbootdemo.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredMapper {

    /*
    * 注册用户 可以通过user.getUserId 拿到id值
    * */
    Integer registedUser(User user);

    /*
    * 通过userid来选择用户的角色
    * */
    void insertUserRole(Integer userId);

    /*
    * 注册管理员 通过user.getUserId 拿到id值
    * */
    Integer registedAdmin(User user);

    /*
    * 通过userid来选择管理员的角色
    * */
    void insertAdminRole(Integer userId);

}
