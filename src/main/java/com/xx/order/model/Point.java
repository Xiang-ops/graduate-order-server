package com.xx.order.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Point {
    private Integer id;
    private Integer userId;
    private String time;
    private Integer addPoint;
    private String month;
    private Integer stepFlag;

    public Integer getStepFlag() {
        return stepFlag;
    }

    public void setStepFlag(Integer stepFlag) {
        this.stepFlag = stepFlag;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getAddPoint() {
        return addPoint;
    }

    public void setAddPoint(Integer addPoint) {
        this.addPoint = addPoint;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
