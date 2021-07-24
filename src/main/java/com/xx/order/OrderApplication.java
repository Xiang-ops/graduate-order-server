package com.xx.order;

import com.xx.order.utils.LocationUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {

//        double lat_b = 28.066031;
//        double lng_b = 113.018325;
////        113.017325,28.073262
//        double distance = LocationUtils.getDistance(113.017325,28.073262,lng_b,lat_b);
//        System.out.print(distance);
        SpringApplication.run(OrderApplication.class, args);
    }

}
