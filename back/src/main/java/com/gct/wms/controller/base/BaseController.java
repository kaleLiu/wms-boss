package com.gct.wms.controller.base;

import com.gct.wms.service.PageService;
import com.gct.wms.service.UserService;
import com.gct.wms.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseController {

    @Autowired
    public UserService userService;

    @Autowired
    public PageService pageService;

    @Autowired
    public ValidateService validateService;

}
