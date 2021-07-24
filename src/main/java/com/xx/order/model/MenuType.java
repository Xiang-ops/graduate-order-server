package com.xx.order.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MenuType {
private Integer id;
private String mtype;
private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
