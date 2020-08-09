package com.mapper;

import com.bean.Changjia;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChangjiaMapper {

    //查询所有序列号
    @Select("select * from sb_changjia ")
    List<Changjia> selectChangjia();



}
