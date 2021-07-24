package com.xx.order.utils;

/**
 * 根据经纬度坐标计算两点的距离
 */
public class LocationUtils {
    private static final Double PI = Math.PI;
    private static final Double PK = 180/PI;

//    public static String getDistance(double lat_a,double lng_a,double lat_b,double lng_b){
//        double t1 = Math.cos(lat_a/PK)*Math.cos(lng_a/PK)*Math.cos(lat_b/PK)*Math.cos(lng_b/PK);
//        double t2 = Math.cos(lat_a/PK)*Math.sin(lng_a/PK)*Math.cos(lat_b/PK)*Math.sin(lng_b/PK);
//        double t3 = Math.sin(lat_a / PK) * Math.sin(lat_b / PK);
//
//        double tt = Math.acos(t1 + t2 + t3);
//        String res = (6366000 * tt) + "";
//        return res.substring(0, res.indexOf("."));
//    }
    public static double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        double Lat1 = rad(latitude1); // 纬度

        double Lat2 = rad(latitude2);

        double a = Lat1 - Lat2;//两点纬度之差

        double b = rad(longitude1) - rad(longitude2); //经度之差

        double s = 2 * Math.asin(Math

                .sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(Lat1) * Math.cos(Lat2) * Math.pow(Math.sin(b / 2), 2)));//计算两点距离的公式

        s = s * 6378137.0;//弧长乘地球半径（半径为米）

        s = Math.round(s * 10000d) / 10000d;//精确距离的数值

        return s;

    }



    private static double rad(double d) {

        return d * Math.PI / 180.00; //角度转换成弧度

    }
}
