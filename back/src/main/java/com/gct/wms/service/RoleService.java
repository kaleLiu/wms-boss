package com.gct.wms.service;

import com.gct.wms.entity.Sort;
import com.gct.wms.mapper.RoleAuthMapper;
import com.gct.wms.mapper.RoleMapper;
import com.gct.wms.model.Role;
import com.gct.wms.util.BeanHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleAuthMapper roleAuthMapper;

    @Autowired
    RoleAuthService roleAuthService;

    /**
     * 重置角色权限
     * 将老权限全部删除
     * 批量添加新权限
     *
     * @param role
     */
    public void resetRoleAuth(Role role) {
        roleAuthMapper.deleteByRoleIds(String.valueOf(role.getId()));
        roleAuthMapper.insertAll(roleAuthService.createList(role));
    }

    public Role getRole(String roleName){
        Role role = new Role();
        role.setName(roleName);
        return BeanHelper.getOne(roleMapper.selectWhere(role,new Sort()));
    }
}
