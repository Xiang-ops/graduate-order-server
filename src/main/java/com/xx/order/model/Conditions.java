package com.xx.order.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Conditions {
    private Integer id;
    private Integer flagId;
    private Integer menuId;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlagId() {
        return flagId;
    }

    public void setFlagId(Integer flagId) {
        this.flagId = flagId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
