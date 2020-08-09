package com.mapper;

import com.bean.Demos;
import com.bean.Qxpre;
import com.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QxpreMapper {


    @Select("SELECT * FROM qx_pre")
    public List<Qxpre> selectQxpreAll();

    @Select("SELECT TOKEN FROM qx_pre")
    public List<Qxpre> selectQxpreTokAll();


    @Select("SELECT * FROM qx_pre where changjia_id=#{changjia_id}")
    public List<Qxpre> selectQxpre(Integer changjia_id);



}
