package com.xx.order.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Menu {
    private Integer id;
    private String name;
    private String price;
    private String picture;
    private String introduction;
    private String mtype;
    private String menuSize;
    private Integer mid;
    private Integer makeTime;

    public Integer getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Integer makeTime) {
        this.makeTime = makeTime;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMenuSize() {
        return menuSize;
    }

    public void setMenuSize(String menuSize) {
        this.menuSize = menuSize;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public Menu(Integer id, String name, String price, String picture, String introduction, String mtype, String menuSize, Integer mid, Integer makeTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.introduction = introduction;
        this.mtype = mtype;
        this.menuSize = menuSize;
        this.mid = mid;
        this.makeTime = makeTime;
    }

    public Menu() {
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
