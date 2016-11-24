package com.gift.mygift.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 作者:  qiang on 2016/11/24 11:14
 * 邮箱:  anworkmail_q@126.com
 * 作用:  时间格式化工具类
 */

public class TimeTool {

    private static final String SERVER = "yyyy-MM-dd";

    private static SimpleDateFormat serverSdf = new SimpleDateFormat(SERVER, Locale.CHINA);

    private static Date getServerTime(String time) {
        Date date = Calendar.getInstance().getTime();
        try {
            date = serverSdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getServerTime(Long time) {
        return serverSdf.format(new Date(time * 1000));
    }

    /**
     * 根据一个日期，返回是周几的字符串
     */
    private static String getWeek(Long time) {
        // 再转换为时间
        Date date = getServerTime(getServerTime(time));
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // int hour=c.get(Calendar.DAY_OF_WEEK);
        // hour中存的就是周几了，其范围 1~7
        // 1=周日 7=周六，其他类推
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }

    private static String getWeekStr(Long sdate) {
        String str = getWeek(sdate);
        if ("1".equals(str)) {
            str = "周日";
        } else if ("2".equals(str)) {
            str = "周一";
        } else if ("3".equals(str)) {
            str = "周二";
        } else if ("4".equals(str)) {
            str = "周三";
        } else if ("5".equals(str)) {
            str = "周四";
        } else if ("6".equals(str)) {
            str = "周五";
        } else if ("7".equals(str)) {
            str = "周六";
        }
        return str;
    }

    /**
     * 精选页面的大图分组时间
     * @param time
     * @return
     */
    public static String getTime1(Long time) {
        return TimeTool.getServerTime(time)
                + "  " + TimeTool.getWeekStr(time);
    }
}
