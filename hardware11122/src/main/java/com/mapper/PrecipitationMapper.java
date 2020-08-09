package com.mapper;

import com.bean.Longitude;
import com.bean.Precipitation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PrecipitationMapper {
    //添加
    @Insert("insert into hw_precipitation(`KEYID`,`SN`,`PRECIPITATION`,`PR_DATE`)values(#{KEYID},#{SN},#{PRECIPITATION},#{PR_DATE})")
    public void insertPrecipitation(Precipitation p);


    @Select("SELECT * FROM hw_precipitation")
    public List<Precipitation> selectPrecipitation();


    //id自增列
    @Select("select (count(*)+1)from hw_precipitation")
    public Integer idPlusPrecipitation();

    @Select("SELECT * FROM hw_precipitation where SN=#{SN}")
    public List<Precipitation> selectPrecipitationSN(String SN);


    //查日期
    @Select("SELECT hw_precipitation.PRECIPITATION FROM `hw_precipitation` WHERE `PR_DATE` >=#{data1} AND `PR_DATE` <=#{data2} AND SN=#{EQ_SN}")
    List<Integer> selectyuliang(String data1, String data2, String EQ_SN);
}
