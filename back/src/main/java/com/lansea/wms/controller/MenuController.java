package com.lansea.wms.controller;

import com.lansea.wms.entity.MenuTreeNode;
import com.lansea.wms.entity.Result;
import com.lansea.wms.model.Auth;
import com.lansea.wms.model.Menu;
import com.lansea.wms.model.User;
import com.lansea.wms.service.AuthService;
import com.lansea.wms.service.MenuService;
import com.lansea.wms.util.BeanHelper;
import com.lansea.wms.util.BeanUtil;
import com.lansea.wms.util.TreeUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright @2020 icarbonx.com
 * author kale
 * Description: 菜单控制器
 * date 2021/2/23
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    @Resource
    private AuthService authService;

    @GetMapping(value = "/all")
    @ApiOperation(value = "菜单列表", notes = "接口")
    Result all() {
        Menu menu = new Menu();
        menu.setState("enable");
        List<Menu> list = menuService.queryMenus(menu);
        return Result.successPage(list);
    }

    @GetMapping(value = "/list")
    @ApiOperation(value = "菜单列表", notes = "接口")
    Result list(Integer roleId) {
        List<Auth> list = authService.selectAllByRoleId(roleId).stream().filter(x->"menu".equals(x.getType()) && "enable".equals(x.getState())).collect(Collectors.toList());
        List<MenuTreeNode> menuTreeNodes = list.stream().map(i->{
            MenuTreeNode menuTreeNode = BeanHelper.copyProperties(i, MenuTreeNode.class);
            return menuTreeNode;
        }).collect(Collectors.toList());
        List<MenuTreeNode> nodes = TreeUtil.bulid(menuTreeNodes,0);
        return Result.success(nodes);
    }
}
