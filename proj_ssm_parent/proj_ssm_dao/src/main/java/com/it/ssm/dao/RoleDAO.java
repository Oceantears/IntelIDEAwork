package com.it.ssm.dao;

import com.it.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *角色dao
 */
public interface RoleDAO {
    @Select("select * from sys_role")
    List<Role> findAll();
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    @Insert("insert into sys_role(id,roleName,roleDesc) values(#{id},#{roleName},#{roleDesc})")
    void save(Role role);

    /**
     * 根据用户的id获取角色列表
     * @param id
     * @return
     */
      @Select("SELECT r.* FROM `sys_user_role` AS s,`sys_role` r  WHERE s.`roleId`=r.`id` AND userId=#{id}")
      @Results({
              @Result(property = "id",column = "id"),
              @Result(property = "permissionList",column = "id",javaType = List.class,
              //根据角色id查询权限列表，com.it.ssm.dao.PermissionDAO.findPermissionByRoleId建方法
              many = @Many(select = "com.it.ssm.dao.PermissionDAO.findPermissionByRoleId" ,fetchType = FetchType.LAZY))
      })
      List<Role> findRoelListByUserId(long id);

     @Select("select * from sys_role where id=#{roleId}")
     @Results({
             @Result(property = "id",column = "id"),
             @Result(property = "permissionList",column = "id",javaType = List.class,
                     //根据角色id查询权限列表，com.it.ssm.dao.PermissionDAO.findPermissionByRoleId建方法
                     many = @Many(select = "com.it.ssm.dao.PermissionDAO.findPermissionByRoleId" ,fetchType = FetchType.LAZY))
     })
    Role findById(Long roleId);

    /**
     * 删除角色所有的权限
     * @param roleId
     */
     @Delete("delete from sys_role_permission where roleId=#{roleId}")
    void deletePermissionsFromRole(Long roleId);

    /**给角色添加新的关系
     *
     * @param roleId
     * @param permissionId
     */
    @Insert("insert into sys_role_permission values(#{param2},#{param1})")
    void addPermissionsToRole(Long roleId, Long permissionId);
}
