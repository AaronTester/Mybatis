package com.mb.util;

import java.util.UUID;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/29
 */
public class DBUtils {

    public static String getRandoId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
