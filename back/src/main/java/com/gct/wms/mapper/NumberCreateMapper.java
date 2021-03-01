package com.gct.wms.mapper;

import com.gct.wms.model.NumberCreate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NumberCreateMapper {

    @Select("select * from number_create where type = #{type} ")
    NumberCreate findByType(@Param("type") String type);

    Integer update(@Param("form") NumberCreate form);

}
