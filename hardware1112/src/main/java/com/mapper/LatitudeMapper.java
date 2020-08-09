package com.mapper;

import com.bean.Getliveinfo;
import com.bean.Latitude;
import com.bean.Lightintensity;
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

    @Select("SELECT * FROM hw_latitude")
    public List<Latitude> selectLatitude();

    //id自增列
    @Select("select (count(*)+1)from hw_latitude")
    public Integer idPlusLatitude();

}
