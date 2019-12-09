package com.it.ssm.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/27 16:55
 * @description：角色表
 * @modified By：
 * @version:     $
 */
 
public class Role {
    private Long id;
    private String roleName;
    private String roleDesc;
    //该角色具备哪些权限--一个角色拥有多个权限
    private List<Permission> permissionList  = new ArrayList<>();
    //该角色被哪些用户使用---一个角色被多个用户所拥有
    private List<SysUser> userList = new ArrayList<>();

    public Role(Long id, String roleName, String roleDesc) {
        this.id = id;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", permissionList=" + permissionList +
                ", userList=" + userList +
                '}';
    }

    public Role(Long id, String roleName, String roleDesc, List<Permission> permissionList, List<SysUser> userList) {
        this.id = id;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.permissionList = permissionList;
        this.userList = userList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public List<SysUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUser> userList) {
        this.userList = userList;
    }
}
