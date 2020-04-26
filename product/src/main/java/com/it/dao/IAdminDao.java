package com.it.dao;/*
@author Laotian
@create 2020-03-10-11:30
*/

import com.it.domain.Admin;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员接口
 */
@Repository
public interface IAdminDao {
    //查询所有信息
   /* @Select("select * from admin")
    List<Admin> findAllAdmin();*/
    //保存信息
    @Insert("insert into admin(admin,name,password) values(#{admin},#{name}," +
            "#{password})")
    void saveAdmin(Admin admin);
    //更新信息
    @Update("update admin set admin=#{admin},name=#{name},password=#{password} " +
            "where id=#{id}")
    void updateAdmin(Admin admin);
    //根据id删除
    @Delete("delete from admin where id=#{id}")
    void deleteAdmin(Admin admin);

    /**
     * 批量删除
     * @param delIds
     * @return
     */
    @Delete("delete from admin where id in (${delIds})")
    int adminDelete(@Param("delIds") String delIds);

    //根据用户名和密码查找
    @Select("select * from admin where name=#{name} and password=#{password}")
    Admin findByNameAndPassword(Admin admin);

    @Select("select * from admin where 1=1 and name like '%${admin.name}%' limit #{startPos},#{pageSize}")
    List<Admin> queryAll(@Param("admin") Admin admin, @Param(value = "startPos") Integer startPos,
						 @Param(value = "pageSize") Integer pageSize);

    @Select("select count(1) from admin")
    int count(Admin admin);

    /*@Select("select * from admin where id=#{id}")
    Admin findById(@Param("id") Long aid);*/


}
