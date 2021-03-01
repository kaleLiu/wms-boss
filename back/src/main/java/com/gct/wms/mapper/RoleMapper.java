package com.gct.wms.mapper;

import com.gct.wms.entity.Sort;
import com.gct.wms.model.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {

    Role findById(@Param("id") Integer id);

    List<Role> selectAll();

    List<Role> selectWhere(@Param("role") Role role, @Param("sort") Sort sort);

    Integer insert(@Param("role") Role role);

    Integer update(@Param("role") Role role);

    @Delete("delete from role where id in (${ids})")
    Integer deleteByIds(@Param("ids") String ids);

}
