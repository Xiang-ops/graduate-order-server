package com.xx.order.utils;

import java.util.UUID;

public class UuidUtil {
    public static String getUUID() {
        String replaceUUID = UUID.randomUUID().toString().replace("-", "");
        return replaceUUID;
    }
}
