package com.it.ssm.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/17 16:02
 * @description：用户模块
 * @modified By：
 * @version:     $
 */
 
public class SysUser {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private Integer status;
    //该用户包含哪些角色--一个用户对应多个角色
    //new的原因是当一些用户没有角色的时候会出现空指针
    private List<Role> roleList = new ArrayList<>();
    public SysUser() {
    }

    public SysUser(Long id, String username, String email, String password, String phoneNum, Integer status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
        this.status = status;
    }

    public SysUser(Long id, String username, String email, String password, String phoneNum, Integer status, List<Role> roleList) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
        this.status = status;
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", status=" + status +
                ", roleList=" + roleList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
