package com.gct.wms.controller;

import com.gct.wms.controller.base.BaseController;
import com.gct.wms.entity.Result;
import com.gct.wms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/access_common")
public class AccessCommonController extends BaseController {

    @Autowired
    UserMapper userMapper;

    Result logout(){
        return null;
    }

}
