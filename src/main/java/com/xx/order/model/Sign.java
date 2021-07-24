package com.xx.order.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Sign {
    private Integer id;
    private Integer userId;
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
