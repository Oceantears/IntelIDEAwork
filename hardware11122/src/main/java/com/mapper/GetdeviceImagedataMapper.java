package com.mapper;

import com.bean.GetdeviceImagedata;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface GetdeviceImagedataMapper {
    //添加
    @Insert("insert into hw_getdeviceImagedata(`KEYID`,`deviceSerial`,`GETDEVICEIMAGEDATA`,`SN`,`GETDEVICEIMAGEDATATow`,`GE_DATE`)values(#{KEYID},#{deviceSerial},#{GETDEVICEIMAGEDATA},#{SN},#{GETDEVICEIMAGEDATATow},#{GE_DATE})")
    public void insertgetdeviceImagedata(GetdeviceImagedata g);

    //添加
    @Insert("insert into hw_getdeviceImagedata(`KEYID`,`deviceSerial`,`GETDEVICEIMAGEDATA`,`SN`,`GETDEVICEIMAGEDATATow`,`GE_DATE`)values(#{KEYID},#{deviceSerial},#{GETDEVICEIMAGEDATA},#{SN},#{GETDEVICEIMAGEDATATow},#{GE_DATE})")
    public void insertgetdeviceImagedataTow(GetdeviceImagedata g);

    @Select("SELECT * FROM hw_getdeviceImagedata")
    public List<GetdeviceImagedata> selectGetdeviceImagedata();

    //id自增列
    @Select("select (count(*)+1)from hw_getdeviceImagedata")
    public Integer idPlusGetdeviceImagedata();

    //查日期
    @Select("SELECT * FROM `hw_getdeviceimagedata` WHERE `GE_DATE` >=#{data1} AND `GE_DATE` <=#{data2} AND SN=#{EQ_SN} ORDER BY `GE_DATE` DESC")
    List<GetdeviceImagedata> selectData(String data1,String data2,String EQ_SN);

    //查日期
    @Select("SELECT * FROM `hw_getdeviceimagedata` WHERE `GE_DATE` >=#{data1} AND `GE_DATE` <=#{data2} AND deviceSerial=#{EQ_SN} ORDER BY `GE_DATE` DESC")
    List<GetdeviceImagedata> selectData2(String data1,String data2,String EQ_SN);

    //查日期
    @Select("SELECT * FROM `hw_getdeviceimagedata` WHERE `GE_DATE` >=#{data1} AND `GE_DATE` <=#{data2} AND SN=#{EQ_SN} ORDER BY `GE_DATE` DESC")
    List<GetdeviceImagedata> selectAllData(String data1,String data2,String EQ_SN);

    //查日期
    @Select("SELECT * FROM `hw_getdeviceimagedata` WHERE `GE_DATE` >=#{data1} AND `GE_DATE` <=#{data2} AND deviceSerial=#{EQ_SN} ORDER BY `GE_DATE` DESC")
    List<GetdeviceImagedata> selectAllData2(String data1,String data2,String EQ_SN);


    @Select("SELECT * FROM hw_getdeviceImagedata where SN=#{SN}")
    public List<GetdeviceImagedata> selectGetdeviceImagedataSN(String SN);

    //查日期
    @Select("SELECT hw_getdeviceimagedata.GETDEVICEIMAGEDATATow FROM `hw_getdeviceimagedata` WHERE `GE_DATE` >=#{data1} AND `GE_DATE` <=#{data2} AND SN=#{EQ_SN} ORDER BY `GE_DATE` DESC")
    List<String> selectDatayi(String data1,String data2,String EQ_SN);

    //查日期
    @Select("SELECT hw_getdeviceimagedata.GETDEVICEIMAGEDATA FROM `hw_getdeviceimagedata` WHERE `GE_DATE` >=#{data1} AND `GE_DATE` <=#{data2} AND deviceSerial=#{EQ_SN} ORDER BY `GE_DATE` DESC")
    List<String> selectDatayi2(String data1,String data2,String EQ_SN);

}
