package com.qin.springbootdemo.domain;


/* author:Qinzijing
*  date: 2019/11/9
*  description:角色实体类
*/
public class Role {
    private Integer role_id;
    private String role_name;
    private String nameZh;

    public Role(Integer role_id, String role_name, String nameZh) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.nameZh = nameZh;
    }

    public Role(String name) {
        this.role_name = name;
    }

    public Integer getRoleId() {
        return role_id;
    }

    public void setRoleId(Integer roleId) {
        this.role_id = roleId;
    }

    public String getName() {
        return role_name;
    }

    public void setName(String name) {
        this.role_name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}
