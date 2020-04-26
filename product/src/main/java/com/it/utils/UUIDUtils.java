package com.it.utils;/*
@author Laotian
@create 2020-03-13-9:03
*/

import java.util.UUID;

public class UUIDUtils {
    // public static void main(String[] args) {
    //     String uuid = getUUID();
    //     System.out.println(uuid);
    // }

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
