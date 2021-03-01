package com.gct.wms.model;

import com.gct.wms.entity.SerializeBase;
import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Copyright @2020 icarbonx.com
 * author kale
 * Description:
 * date 2021/2/23
 */
@Repository
@ApiModel(value = "Menu", description = "菜单")
public class Menu extends SerializeBase {

    private Long id;

    private String title;

    private String path;

    private String url;

    private Long parentId;

    private String description;

    private Date createTime;

    private String creator;

    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
