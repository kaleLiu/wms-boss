package com.gct.wms.service;

import com.gct.wms.mapper.ApproveLogMapper;
import com.gct.wms.model.ApproveLog;
import com.gct.wms.model.StockEntry;
import com.gct.wms.model.StockTrans;
import com.gct.wms.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApproveLogService extends BaseService {

    @Autowired
    ApproveLogMapper approveLogMapper;

    /**
     * 添加出入库审批日志
     *
     * @param stockEntry 出入库
     * @return
     */
    public ApproveLog addStockEntryLog(StockEntry stockEntry) {
        ApproveLog approveLog = new ApproveLog();
        approveLog.setType(1);
        String remark = stockEntry.getRemark();
        if (stockEntry.getStatus() == 4) {
            remark = stockEntry.getRejectRemark();
        }
        approveLogMapper.insert(setLogInfo(approveLog, stockEntry.getStatus(), stockEntry.getId(), remark));
        return approveLog;
    }

    /**
     * 添加以为日志
     *
     * @param stockTrans 移位单
     * @return
     */
    public ApproveLog addStockTransLog(StockTrans stockTrans) {
        ApproveLog approveLog = new ApproveLog();
        approveLog.setType(2);
        String remark = stockTrans.getRemark();
        if (stockTrans.getStatus() == 4) {
            remark = stockTrans.getRejectRemark();
        }
        approveLogMapper.insert(setLogInfo(approveLog, stockTrans.getStatus(), stockTrans.getId(), remark));
        return approveLog;
    }

    private ApproveLog setLogInfo(ApproveLog approveLog, Integer status, Integer pid, String remark) {
        approveLog.setPid(pid);
        approveLog.setStatus(status);
        approveLog.setCreateUidToLoginUser(userService);
        approveLog.setRemark(remark);
        return approveLog;
    }
}
