package com.xx.order.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Member {
    private Integer id;
    private String levelName;
    private Integer shopDiscount;
    private Integer amount;
    private Integer couponDiscount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getShopDiscount() {
        return shopDiscount;
    }

    public void setShopDiscount(Integer shopDiscount) {
        this.shopDiscount = shopDiscount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(Integer couponDiscount) {
        this.couponDiscount = couponDiscount;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
