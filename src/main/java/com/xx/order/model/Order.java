package com.xx.order.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Order {
    private Integer id;
    private String date;
    private String price;
    private Integer isCash;
    private String clientName;
    private String number;
    private String menuName;
    private Integer userId;
    private String menuTime;
    private String phone;
    private Integer waitTime;

    public Integer getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMenuTime() {
        return menuTime;
    }

    public void setMenuTime(String menuTime) {
        this.menuTime = menuTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getIsCash() {
        return isCash;
    }

    public void setIsCash(Integer isCash) {
        this.isCash = isCash;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
