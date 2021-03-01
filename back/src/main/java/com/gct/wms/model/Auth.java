package com.gct.wms.model;

import com.gct.wms.entity.SerializeBase;
import com.gct.wms.entity.ValidClass;
import io.swagger.annotations.ApiModel;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Min;

@Repository
@ApiModel(value = "Auth")
public class Auth extends SerializeBase {

    @Min(value = 1, message = "id非法", groups = {ValidClass.EditForm.class})
    private Integer id;
    private Integer pid;
    @Length(min = 2, max = 40, message = "名称长度为 2-40")
    private String name;
    @Length(min = 2, max = 100, message = "url长度为 2-100")
    private String url;

    private String type;

    private String icon;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
