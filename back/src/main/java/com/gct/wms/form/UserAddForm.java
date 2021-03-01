package com.gct.wms.form;

import com.gct.wms.entity.ValidClass;
import com.gct.wms.model.User;
import com.gct.wms.validate.Password;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "UserAddForm", description = "添加用户表单")
public class UserAddForm extends User {

    @ApiModelProperty(value = "重复密码")
    @NotBlank(message = "重复密码不能为空", groups = {ValidClass.AddForm.class, ChangeMyInfo.class})
    @Password(message = "重复密码格式错误")
    private String rePassword;

    @NotBlank(message = "原密码不能为空", groups = { ChangeMyInfo.class})
    @Password(message = "原密码格式错误")
    private String oldPassword;

    public boolean verifyRePassword() {
        return getPassword().equals(rePassword);
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
