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
}
