package com.mapper;

import com.bean.Lightintensity;
import com.bean.Longitude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface LongitudeMapper {


    //查询
    @Select("select * from hw_longitude where KEYID=#{KEYID} ")
    Longitude find(@Param("KEYID") Integer KEYID);
    //添加
    @Insert("insert into hw_longitude(`KEYID`,`SN`,`LONGITUDE`,`LO_DATE`)values(#{KEYID},#{SN},#{LONGITUDE},#{LO_DATE})")
    public void insertLongitude(Longitude u);

    @Select("SELECT * FROM hw_longitude")
    public List<Longitude> selectLongitude();


    //id自增列
    @Select("select (count(*)+1)from hw_longitude")
    public Integer idPlusLongitude();

}
