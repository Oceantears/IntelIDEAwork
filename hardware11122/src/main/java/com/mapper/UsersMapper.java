package com.mapper;

import com.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UsersMapper {

    @Insert("insert into hw_user(`KEYID`,`USERNAME`,`PWD`)values(#{KEYID},#{USERNAME},#{PWD})")
    void insert(User u);//保存、添加用户

    @Delete("delete from hw_user where KEYID=#{KEYID} ")
    void delete(@Param("KEYID") Integer KEYID);//删除用户

    @Update("update hw_user set (USERNAME = #{USERNAME},PWD = #{PWD}) where KEYID=#{KEYID} ")
    void update(User u);//修改用户

   /* @Select("select * from hw_user whereKEYID=#{KEYID}")
    User findByID(@Param("KEYID") Integer KEYID);//根据id查询用户*/

    @Select("select * from hw_user where USERNAME=#{USERNAME} AND PWD=#{PWD}")
    User login(@Param("USERNAME")String username,@Param("PWD")String passwd);//登陆


    /* Page<User> findAll();//分页*/

    //id自增列
    @Select("select (count(*)+1)from hw_user")
    public Integer idPlusUser();

}
