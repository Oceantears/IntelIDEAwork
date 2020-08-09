package com.mapper;

import com.bean.AtmosphericHumidity;
import com.bean.GetdeviceImagedata;
import com.bean.Getliveinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GetliveinfoMapper {
    //添加
    @Insert("insert into hw_getliveinfo(`KEYID`,`SN`,`GETLIVEINFO`,`GE_DATE`,`GEJPG`)values(#{KEYID},#{SN},#{GETLIVEINFO},#{GE_DATE},#{GEJPG})")
    public void insertgetliveinfo(Getliveinfo g);

    @Select("SELECT * FROM hw_getliveinfo")
    public List<Getliveinfo> selectGetliveinfo();

    //id自增列
    @Select("select (count(*)+1)from hw_getliveinfo")
    public Integer idPlusGetliveinfo();


    @Select("SELECT * FROM hw_getliveinfo where SN=#{SN} ")
    public List<Getliveinfo> selectGetliveinfoSN(@Param("SN") String SN);

    @Select("SELECT * FROM hw_getliveinfo where SN=#{SN} ")
    public Getliveinfo selectGetliveinfoSNo(@Param("SN") String SN);


}
