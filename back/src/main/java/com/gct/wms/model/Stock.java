package com.gct.wms.model;


import com.gct.wms.entity.ValidClass;
import com.gct.wms.model.base.BaseUser;
import com.gct.wms.validate.CodeValidate;
import com.gct.wms.validate.NameValidate;
import com.gct.wms.validate.RemarkValidate;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Min;

@Repository
public class Stock extends BaseUser {

    @Min(value = 1, message = "id 非法", groups = {ValidClass.EditForm.class})
    private Integer id;

    @CodeValidate
    private String code;

    @NameValidate
    private String name;

    @Min(value = 1, message = "请选择仓库")
    private Integer warehouseId;

    @Min(value = 1, message = "请选择库区")
    private Integer reservoirId;

    @RemarkValidate
    private String remark;

    private String warehouseName;
    private String reservoirName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getReservoirId() {
        return reservoirId;
    }

    public void setReservoirId(Integer reservoirId) {
        this.reservoirId = reservoirId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getReservoirName() {
        return reservoirName;
    }

    public void setReservoirName(String reservoirName) {
        this.reservoirName = reservoirName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
