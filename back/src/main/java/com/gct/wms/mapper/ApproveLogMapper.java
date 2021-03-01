package com.gct.wms.mapper;

import com.gct.wms.model.ApproveLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApproveLogMapper {

    Integer insert(@Param("approveLog") ApproveLog approveLog);

}
