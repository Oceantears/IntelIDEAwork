package com.mapper;

import com.bean.Winddirection;
import com.bean.Windspeed;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface WindspeedMapper {

    //添加
    @Insert("insert into hw_windspeed(`KEYID`,`SN`,`WINDSPEED`,`WI_DATE`)values(#{KEYID},#{SN},#{WINDSPEED},#{WI_DATE})")
    public void insertWindspeed(Windspeed win);

    @Select("SELECT * FROM hw_windspeed")
    public List<Windspeed> selectWindspeed();

    //id自增列
    @Select("select (count(*)+1)from hw_windspeed")
    public Integer idPlusWindspeed();

    @Select("SELECT * FROM hw_windspeed where  SN=#{SN}")
    public List<Windspeed> selectWindspeedSN(String SN);

    //查日期
    @Select("SELECT hw_windspeed.WINDSPEED FROM `hw_windspeed` WHERE `WI_DATE` >=#{data1} AND `WI_DATE` <=#{data2} AND SN=#{EQ_SN}")
    List<Integer> selectfengsu(String data1, String data2, String EQ_SN);
}
