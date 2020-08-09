package com.mapper;

import com.bean.AtmosphericHumidity;
import com.bean.GetdeviceImagedata;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GetdeviceImagedataMapper {
    //添加
    @Insert("insert into hw_getdeviceImagedata(`KEYID`,`deviceSerial`,`GETDEVICEIMAGEDATA`,`GE_DATE`)values(#{KEYID},#{deviceSerial},#{GETDEVICEIMAGEDATA},#{GE_DATE})")
    public void insertgetdeviceImagedata(GetdeviceImagedata g);

    //添加
    @Insert("insert into hw_getdeviceImagedata(`KEYID`,`deviceSerial`,`GETDEVICEIMAGEDATA`,`SN`,`GETDEVICEIMAGEDATATow`,`GE_DATE`)values(#{KEYID},#{deviceSerial},#{GETDEVICEIMAGEDATA},#{SN},#{GETDEVICEIMAGEDATATow},#{GE_DATE})")
    public void insertgetdeviceImagedataTow(GetdeviceImagedata g);

    @Select("SELECT * FROM hw_getdeviceImagedata")
    public List<GetdeviceImagedata> selectGetdeviceImagedata();

    //id自增列
    @Select("select (count(*)+1)from hw_getdeviceImagedata")
    public Integer idPlusGetdeviceImagedata();
}
