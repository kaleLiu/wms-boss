package com.lansea.wms.mapper;

import com.lansea.wms.entity.Sort;
import com.lansea.wms.model.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Copyright @2020 icarbonx.com
 * author kale
 * Description: 菜单
 * date 2021/2/23
 */
@Mapper
public interface MenuMapper {

    List<Menu> selectWhere(@Param("menu") Menu menu, @Param("sort") Sort sort);
    /*Menu findById(@Param("id") Integer id);

    Integer insert(@Param("menu") Menu menu);

    Integer update(@Param("menu") Menu menu);*/
}
