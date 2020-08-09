package com.mapper;

import com.bean.Gongsijidi;
import com.bean.Hw_Equipment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HwEquipmentMapper {

    @Insert("insert into hw_equipment(`KEYID`,\n" +
            "             `SB_CHANGJIA`,\n" +
            "             `SB_CS_KEYID`,\n" +
            "             `EQ_NAME`,\n" +
            "             `EQ_ADDRESS`,\n" +
            "             `EQ_SN`,\n" +
            "             `SP_YZM`,\n" +
            "             `EQ_DATE`,\n" +
            "             `EQ_LONGITUDE`,\n" +
            "             `EQ_LATITUDE`,\n" +
            "             `EQ_company_id`,\n" +
            "             `EQ_place_id`,\n" +
            "             `EQ_STATE`)values(#{KEYID},#{SB_CHANGJIA},#{SB_CS_KEYID},#{EQ_NAME}," +
            "#{EQ_ADDRESS},#{EQ_SN},#{SP_YZM},#{EQ_DATE},#{EQ_LONGITUDE},#{EQ_LATITUDE},#{EQ_company_id}," +
            "#{EQ_place_id},#{EQ_STATE})")
    void insert(Hw_Equipment u);

    @Update("update hw_equipment SET SB_CHANGJIA = #{SB_CHANGJIA},EQ_STATE=#{EQ_STATE},SB_CS_KEYID = #{SB_CS_KEYID},EQ_NAME = #{EQ_NAME},EQ_ADDRESS = #{EQ_ADDRESS},EQ_SN=#{EQ_SN},SP_YZM = #{SP_YZM},EQ_DATE = #{EQ_DATE},EQ_LONGITUDE = #{EQ_LONGITUDE},EQ_LATITUDE = #{EQ_LATITUDE},EQ_company_id = #{EQ_company_id},EQ_place_id = #{EQ_place_id} where KEYID=#{KEYID}")
    void updatehw_equipment(Hw_Equipment u);

    @Delete("delete from hw_equipment where KEYID=#{KEYID} ")
    void delete(@Param("KEYID") Integer KEYID);

    @Select("select * from hw_equipment where EQ_NAME like '%' #{EQ_NAME} '%'")
    public List<Hw_Equipment> muhuList(String EQ_NAME);

    //查询所有
    @Select("select * from hw_equipment where EQ_STATE=${0}")
    List<Hw_Equipment> selecthw_equipmentEQ_STATEAll();

    @Delete("update hw_equipment SET EQ_STATE=${1}  where KEYID=#{KEYID} ")
    void del(@Param("KEYID") Integer KEYID);

    @Select("select * from hw_equipment where KEYID=#{KEYID} ")
    Hw_Equipment find(@Param("KEYID") Integer KEYID);

    @Select("select * from hw_equipment where SB_CS_KEYID=${1} and EQ_STATE=${0}")
    List<Hw_Equipment> selecthw_equipmentAll();

    //id自增列
    @Select("select (count(*)+1)from hw_equipment")
    public Integer idPlushw_equipment();

    @Select("select * from hw_equipment where EQ_SN=#{EQ_SN} and EQ_STATE=${0} ")
    Hw_Equipment selectSN(@Param("EQ_SN") String EQ_SN);

    @Select("select * from hw_equipment where EQ_SN=#{EQ_SN} ")
    List<Hw_Equipment> selectSNs(@Param("EQ_SN") String EQ_SN);

    @Select("SELECT company_ifo.`company_name`,place_info.`place_title`,hw_equipment.`EQ_SN`,hw_equipment.`KEYID`,hw_equipment.`EQ_NAME` FROM `company_ifo`\n" +
            "            JOIN `hw_equipment`\n" +
            "            ON company_ifo.`ID`=hw_equipment.`EQ_company_id`\n" +
            "            JOIN `place_info`\n" +
            "            ON place_info.`id`=`hw_equipment`.`EQ_place_id`")
    List<Gongsijidi> selectGongsijidi();


    @Select("SELECT company_ifo.`company_name`,place_info.`place_title`,hw_equipment.`EQ_SN`,hw_equipment.`KEYID`,hw_equipment.`EQ_NAME` FROM `company_ifo`\n" +
            "            JOIN `hw_equipment`\n" +
            "            ON company_ifo.`ID`=hw_equipment.`EQ_company_id`\n" +
            "            JOIN `place_info`\n" +
            "            ON place_info.`id`=`hw_equipment`.`EQ_place_id`\n" +
            "            WHERE hw_equipment.`EQ_SN`=#{EQ_SN}")
    Gongsijidi selectGongsijidiKEYID(String EQ_SN);

    @Select("select hw_equipment.EQ_SN from hw_equipment where KEYID=#{KEYID} ")
    String selectoneSN(@Param("KEYID") Integer KEYID);

}