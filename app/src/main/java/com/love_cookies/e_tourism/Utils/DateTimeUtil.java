package com.love_cookies.e_tourism.Utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by xiekun on 2016/4/14 0014.
 *
 * 时间日期工具类
 */
public class DateTimeUtil {

    private static DateTimeUtil instance;

    /**
     * DateTimeUtil
     *
     * @return DateTimeUtil
     */
    public static DateTimeUtil getInstance() {
        if (instance == null) {
            instance = new DateTimeUtil();
        }
        return instance;
    }

    /**
     * 获取当前时间
     */
    public String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date curDate = new Date(System.currentTimeMillis());
        return formatter.format(curDate);
    }
}
