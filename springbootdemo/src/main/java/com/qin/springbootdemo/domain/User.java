package com.qin.springbootdemo.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* author:Qinzijing
*  date: 2019/11/9
*  description:用户实体类
*/
public class User implements UserDetails {
    private Integer userId;
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean locked;
    private List<Role> roles;


    /*
    * 获取当前用户对象具有的角色信息
    * */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    /*
    * 获取当前用户的密码
    * */
    @Override
    public String getPassword() {
        return password;
    }
    /*
    * 获取当前用户的用户名
    * */
    @Override
    public String getUsername() {
        return username;
    }
    /*
    * 当前用户是否未过期
    * */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /*
    * 当前用户是否未锁定
    * */
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }
    /*
    * 当前账户密码是否未过期
    * */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /*
    * 当前账户是否可用
    * */
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
