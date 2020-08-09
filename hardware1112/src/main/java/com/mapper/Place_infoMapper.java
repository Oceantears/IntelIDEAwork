package com.mapper;

import com.bean.Place_info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface Place_infoMapper {


    @Select("SELECT p.place_content FROM Place_info AS p inner join Hw_Equipment AS h WHERE h.EQ_place_id=p.id AND EQ_SN=#{EQ_SN} ")
    Place_info selectPlace(@Param("EQ_SN") String EQ_SN);

    @Select("select * from place_info where company_id=#{company_id}")
    public List<Place_info> selectgsid(@Param("company_id") Integer company_id);

    @Select("select * from place_info")
    public List<Place_info> selectAll();

}
