package com.xx.order.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Shop {
    private Integer id;
    private String shopName;
    private String shopIntro;
    private String longitude;
    private String latitude;
    private String address;
    private String timeStart;
    private String timeEnd;
    private String shopPic;
    private String monthSales;
    private String linkPhone;

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopIntro() {
        return shopIntro;
    }

    public void setShopIntro(String shopIntro) {
        this.shopIntro = shopIntro;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getShopPic() {
        return shopPic;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void setShopPic(String shopPic) {
        this.shopPic = shopPic;
    }

    public String getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(String monthSales) {
        this.monthSales = monthSales;
    }

    public Shop(Integer id, String shopName, String shopIntro, String longitude, String latitude, String address, String timeStart, String timeEnd, String shopPic, String monthSales, String linkPhone) {
        this.id = id;
        this.shopName = shopName;
        this.shopIntro = shopIntro;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.shopPic = shopPic;
        this.monthSales = monthSales;
        this.linkPhone = linkPhone;
    }

    public Shop() {
    }
}
