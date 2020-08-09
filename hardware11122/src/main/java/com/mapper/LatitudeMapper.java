package com.mapper;

import com.bean.Getliveinfo;
import com.bean.Latitude;
import com.bean.Lightintensity;
import com.bean.Precipitation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface LatitudeMapper {
    //查询
    @Select("select * from hw_latitude where KEYID=#{KEYID} ")
    Latitude find(@Param("KEYID") Integer KEYID);
    //添加
    @Insert("insert into hw_latitude(`KEYID`,`SN`,`LATITUDE`,`LA_DATE`)values(#{KEYID},#{SN},#{LATITUDE},#{LA_DATE})")
    public void insertLatitude(Latitude u);

    @Select("SELECT * FROM hw_latitude where SN=#{SN} ")
    Latitude selectLatitude(@Param("SN") String  SN);

    //id自增列
    @Select("select (count(*)+1)from hw_latitude")
    public Integer idPlusLatitude();


    @Select("SELECT * FROM hw_precipitation where SN=#{SN}")
    public List<Precipitation> selectPrecipitationSN(String SN);


    //查日期
    @Select("SELECT hw_precipitation.PRECIPITATION FROM `hw_precipitation` WHERE `PR_DATE` >=#{data1} AND `PR_DATE` <=#{data2} AND SN=#{EQ_SN}")
    List<Integer> selectyuliang(String data1, String data2, String EQ_SN);

}
