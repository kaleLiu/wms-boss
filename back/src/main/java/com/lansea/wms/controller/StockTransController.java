package com.lansea.wms.controller;


import com.lansea.wms.controller.base.BaseController;
import com.lansea.wms.entity.Result;
import com.lansea.wms.entity.ValidClass;
import com.lansea.wms.form.DeleteIdsForm;
import com.lansea.wms.mapper.StockMapper;
import com.lansea.wms.mapper.StockTransMapper;
import com.lansea.wms.model.StockTrans;
import com.lansea.wms.service.StockTransService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.List;

@RestController
@RequestMapping(value = "/stock_trans")
@Api(description = "库存移位")
public class StockTransController extends BaseController {

    @Autowired
    StockTransMapper stockTransMapper;

    @Autowired
    StockTransService stockTransService;

    @GetMapping(value = "/selectWhere")
    @ApiOperation(value = "条件分页列表")
    Result selectWhere(StockTrans form) {
        pageService.setPaginate();
        List<StockTrans> list = stockTransMapper.selectWhere(form, pageService.createSort());
        return Result.successPage(list);
    }

    @GetMapping(value = "/get_by_id")
    @ApiOperation(value = "根据id 查找")
    Result getById(Integer id) {
        return Result.success(stockTransMapper.findById(id));
    }

    @PostMapping(value = "/insert")
    @ApiOperation(value = "新增移位单")
    Result insert(@Validated @RequestBody StockTrans form, BindingResult result) {
        if (result.hasErrors()) {
            return Result.errorByBindingResult(result);
        }
        stockTransService.insert(form);
        return Result.success("添加成功");
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改信息")
    Result update(@Validated({ValidClass.EditForm.class, Default.class}) @RequestBody StockTrans form, BindingResult result) {
        if (result.hasErrors()) {
            return Result.errorByBindingResult(result);
        }
        StockTrans stockTrans = stockTransMapper.findById(form.getId());
        Integer status = stockTrans.getStatus();
        if (status != 1 && status != 4) {
            return Result.error("库位单已被审批，无法修改！");
        }
        form.setMoveCount(stockTrans.getMoveCount());
        stockTransService.update(form);
        return Result.success("修改成功");
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除移库信息")
    Result delete(@Validated @RequestBody DeleteIdsForm form, BindingResult result) {
        if (result.hasErrors()) {
            return Result.errorByBindingResult(result);
        }
        Integer num = stockTransService.delete(form);
        return Result.successDelete(num);
    }

    @PostMapping(value = "/approve")
    @ApiOperation(value = "审批")
    Result approve(@Validated({ValidClass.EditForm.class, Default.class}) @RequestBody StockTrans form, BindingResult result) {
        if (result.hasErrors()) {
            return Result.errorByBindingResult(result);
        }
        StockTrans stockTrans = stockTransMapper.findById(form.getId());
        if (!stockTrans.canApprove()) {
            return Result.error("非法提交1");
        }
        Integer fStatus = form.getStatus();
        if (fStatus != 3 && fStatus != 4) {
            return Result.error("非法请求2");
        }
        stockTransService.approve(form);
        return Result.success("审批成功");
    }

}
