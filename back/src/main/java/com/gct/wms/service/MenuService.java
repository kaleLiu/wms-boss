package com.gct.wms.service;

import com.gct.wms.mapper.MenuMapper;
import com.gct.wms.model.Menu;
import com.gct.wms.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright @2020 icarbonx.com
 * author kale
 * Description: 菜单service
 * date 2021/2/23
 */
@Service
public class MenuService extends BaseService {

    @Resource
    private MenuMapper menuMapper;

    public List<Menu> queryMenus(Menu menu){
        List<Menu> list = menuMapper.selectWhere(menu,pageService.createSort());
        return list;
    }
}
