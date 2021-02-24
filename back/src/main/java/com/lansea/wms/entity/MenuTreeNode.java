package com.lansea.wms.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @2020 icarbonx.com
 * author kale
 * Description: 菜单树
 * date 2021/2/24
 */
public class MenuTreeNode {

    protected int id;

    protected int pid;

    protected String name;

    protected String url;

    protected String icon;

    List<MenuTreeNode> children = new ArrayList<MenuTreeNode>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
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

    public List<MenuTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTreeNode> children) {
        this.children = children;
    }

    public void add(MenuTreeNode node){
        children.add(node);
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
