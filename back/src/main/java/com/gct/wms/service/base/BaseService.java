package com.gct.wms.service.base;

import com.gct.wms.service.ApproveLogService;
import com.gct.wms.service.CommonService;
import com.gct.wms.service.UserService;
import com.gct.wms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    @Autowired
    protected PageService pageService;

    @Autowired
    protected UserService userService;

    @Autowired
    protected ApproveLogService approveLogService;

    @Autowired
    protected CommonService commonService;
}
