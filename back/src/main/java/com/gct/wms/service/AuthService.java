package com.gct.wms.service;

import com.gct.wms.mapper.AuthMapper;
import com.gct.wms.model.Auth;
import com.gct.wms.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Copyright @2020 icarbonx.com
 * author kale
 * Description: 权限service
 * date 2021/2/24
 */
@Service
public class AuthService extends BaseService {

    @Resource
    private AuthMapper authMapper;

    public List<Auth> selectAllByRoleId(Integer roleId){
        if (roleId == null) {
            return Collections.EMPTY_LIST;
        }
        return authMapper.selectAllByRoleId(roleId);
    }
}
