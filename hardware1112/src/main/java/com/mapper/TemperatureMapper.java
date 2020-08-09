package com.mapper;

import com.bean.Temperature;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TemperatureMapper {
//查询
    //@Select("select * from hw_temperature where KEYID=#{KEYID} ")
    Temperature find(@Param("KEYID") Integer KEYID);
//添加
    @Insert("insert into hw_temperature(`KEYID`,`SN`,`TEMPERATURE`,`TE_DATE`)values(#{KEYID},#{SN},#{TEMPERATURE},#{TE_DATE})")
    public void insertTemperature(Temperature u);


    @Select("SELECT * FROM hw_temperature")
    public List<Temperature> selectTemperature();

    //id自增列
    @Select("select (count(*)+1)from hw_temperature")
    public Integer idPlusTemperature();

}
