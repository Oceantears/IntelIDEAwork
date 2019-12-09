package com.it.ssm.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/27 17:47
 * @description：权限bean
 * @modified By：
 * @version:     $
 */
 
public class Permission {
    private Long id;
    private String permissionName;
    private String url;
    private Long pid;
    //该权限被哪些角色所拥有--一个权限可以被多个角色所拥有
    private List<Role> roleList = new ArrayList<>();

    public List<Role> getRoleList() {
        return roleList;
    }

    public Permission(Long id, String permissionName, String url, Long pid, List<Role> roleList) {
        this.id = id;
        this.permissionName = permissionName;
        this.url = url;
        this.pid = pid;
        this.roleList = roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Permission() {
    }

    public Permission(Long id, String permissionName, String url, Long pid) {
        this.id = id;
        this.permissionName = permissionName;
        this.url = url;
        this.pid = pid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", roleList=" + roleList +
                '}';
    }
}
