package com.lansea.wms.service;

import com.lansea.wms.mapper.MenuMapper;
import com.lansea.wms.model.Menu;
import com.lansea.wms.model.User;
import com.lansea.wms.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
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
