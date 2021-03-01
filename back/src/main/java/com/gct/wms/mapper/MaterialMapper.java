package com.gct.wms.mapper;

import com.gct.wms.entity.Sort;
import com.gct.wms.model.Material;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MaterialMapper {

    List<Material> selectWhere(@Param("material") Material material, @Param("sort") Sort sort);

    Material findById(@Param("id") Integer id);

    Integer insert(@Param("material") Material material);

    Integer update(@Param("material") Material material);

    @Delete("update material set is_del = now() where id in (${ids})")
    Integer delete(@Param("ids") String ids);

    List<Material> selectByTypes(@Param("types") String types);
}
