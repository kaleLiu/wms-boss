package com.gct.wms.mapper;

import com.gct.wms.entity.Sort;
import com.gct.wms.model.LoginRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginRecordMapper {

    Integer insert(@Param("form") LoginRecord form);

    List<LoginRecord> selectWhere(@Param("form") LoginRecord form, @Param("sort") Sort sort);

}
