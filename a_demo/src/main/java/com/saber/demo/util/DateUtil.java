package com.saber.demo.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author baiyang
 * @date 2020/9/8
 */
public class DateUtil {

    public static Date getDate(int i, int number) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        if (i == 1) {
            //几年之前的今天
            ca.add(Calendar.YEAR, -number);
            return ca.getTime();
        }
        if (i == 2) {
            //几个月之前的今天
            ca.add(Calendar.MONTH, -number);
            return ca.getTime();
        }
        if (i == 3) {
//            几个日之前的今天
            ca.add(Calendar.DATE, -number);
            return ca.getTime();
        }
        return null;
    }
}
