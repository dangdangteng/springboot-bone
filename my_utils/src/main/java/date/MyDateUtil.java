package date;

import java.util.Calendar;
import java.util.Date;

/**
 * @author baiyang
 * @date 2020/9/9
 */
public class MyDateUtil {

    /**
     * @param number 算不上工具类只是记录一下如何计算几天之前
     * @return
     */
    public static Date getDate(int number) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        //几年之前的今天
        ca.add(Calendar.YEAR, -number);
        //几个月之前
        ca.add(Calendar.MONTH, -number);
        //几天之前
        ca.add(Calendar.DATE, -number);
        return ca.getTime();
    }
}
