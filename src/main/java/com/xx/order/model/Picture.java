package com.xx.order.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Picture {
    private Integer id;
    private String name;
    private String picUrl;
    private String uuid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
