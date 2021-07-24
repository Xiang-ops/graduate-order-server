package com.xx.order.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MenuInOrder {
    private Integer id;
    private String menuName;
    private String price;
    private String menuSize;
    private String picture;
    private Integer number;//数目
    private String orderNumber;//订单编号

    public MenuInOrder( String menuName, String price, String menuSize, String picture, Integer number, String orderNumber) {
        this.menuName = menuName;
        this.price = price;
        this.menuSize = menuSize;
        this.picture = picture;
        this.number = number;
        this.orderNumber = orderNumber;
    }

    public MenuInOrder() {
    }

    public String getMenuSize() {
        return menuSize;
    }

    public void setMenuSize(String menuSize) {
        this.menuSize = menuSize;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
