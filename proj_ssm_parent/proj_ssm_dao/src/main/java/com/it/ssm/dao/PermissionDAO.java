package com.it.ssm.dao;

import com.it.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
public interface PermissionDAO {
    /**
     * 查询所有权限
     * @return
     */
    @Select("select * from sys_permission")
    List<Permission> findAll();

    /**
     * 查询所有的父权限
     * @return
     */
    @Select("select * from sys_permission where pid=0")
    List<Permission> findAllParentPermission();
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    @Insert("insert into sys_permission (id,permissionName,url,pid) values (#{id},#{permissionName}, #{url}, #{pid})")
    void save(Permission permission);

    /**
     *
     *  根据角色Id查询角色id
     *
     * @param roleId
     * @return
     */
    @Select("SELECT sp.*  FROM  `sys_role_permission`AS rp, `sys_permission` AS  sp WHERE rp.`permissionId`= sp.`id` AND roleId=#{roleId}")

    List<Permission> findPermissionByRoleId(long roleId);
}
