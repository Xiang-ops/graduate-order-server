package com.xx.order.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Coupon {
    private Integer id;
    private Integer hreshold;
    private Integer subPrice;
    private String endDate;
    private Integer couponType;
    private Integer point;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHreshold() {
        return hreshold;
    }

    public void setHreshold(Integer hreshold) {
        this.hreshold = hreshold;
    }

    public Integer getSubPrice() {
        return subPrice;
    }

    public void setSubPrice(Integer subPrice) {
        this.subPrice = subPrice;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getCouponType() {
        return couponType;
    }

    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
