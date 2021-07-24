package com.xx.order.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserCoupon {
    private Integer id;
    private Integer couponId;
    private Integer userId;
    private Integer hreshold;
    private Integer subPrice;
    private String endDate;
    private Integer couponType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public UserCoupon(Integer couponId, Integer userId, Integer hreshold, Integer subPrice, String endDate, Integer couponType) {
        this.couponId = couponId;
        this.userId = userId;
        this.hreshold = hreshold;
        this.subPrice = subPrice;
        this.endDate = endDate;
        this.couponType = couponType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
