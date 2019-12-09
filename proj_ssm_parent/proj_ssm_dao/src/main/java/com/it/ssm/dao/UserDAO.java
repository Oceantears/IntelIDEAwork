package com.it.ssm.dao;

import com.it.ssm.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.context.annotation.Lazy;

import java.util.List;


public interface UserDAO {
    /**
     * 根据用户名查询用户(唯一对象)
     * @param username
     * @return
     */
    @Select("select * from sys_user where-- username=#{username}")
    @Results({
            @Result(property = "id",column = "id"),
            //通过用户的id可以查询到角色id
            @Result(property = "roleList",column = "id",javaType = List.class,
                    //根据用户id查询角色列表的
                    //findRoelListByUserId() 该方法应该写在RoleDAO中
                    //com.it.ssm.dao.RoleDAO.findRoelListByUserId(id)
                    //延迟加载
                    many = @Many(select="com.it.ssm.dao.RoleDAO.findRoelListByUserId",fetchType = FetchType.LAZY))
    })
    SysUser findByName(String username);
    @Select("select * from sys_user ")
    List<SysUser> findAll();
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    @Insert("insert into sys_user (id,username,email,password,phoneNum,status) values (#{id},#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(SysUser sysUser);
    @Select("select * from sys_user where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            //通过用户的id可以查询到角色id
       @Result(property = "roleList",column = "id",javaType = List.class,
               //根据用户id查询角色列表的
               //findRoelListByUserId() 该方法应该写在RoleDAO中
               //com.it.ssm.dao.RoleDAO.findRoelListByUserId(id)
               //延迟加载
               many = @Many(select="com.it.ssm.dao.RoleDAO.findRoelListByUserId",fetchType = FetchType.LAZY))
    })
    SysUser findById(long id);

    /**
     * 删除用户原来所有的角色
     * 和中间表有关系
     * @param userId
     */
    @Delete("delete from sys_user_role where userId=#{userId}")
    void delRolesFromUser(Long userId);

    /**
     * 给用户添加角色关系
     * @param userId
     * @param roleId
     */
    @Insert("insert into sys_user_role values(#{param1},#{param2})")
    void saveRoleToUser(Long userId, Long roleId);
}
