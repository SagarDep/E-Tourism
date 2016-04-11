package com.love_cookies.e_tourism.Utils;

import android.content.Context;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 取天气的图
 */
public class WeatherImgUtil {

    private static WeatherImgUtil instance;

    /**
     * WeatherImgUtil
     *
     * @return WeatherImgUtil
     */
    public static WeatherImgUtil getInstance() {
        if (instance == null) {
            instance = new WeatherImgUtil();
        }
        return instance;
    }

    /**
     * 获取天气图片
     * @param context
     * @param img_name
     * @return
     */
    public int getWeatherImg(Context context, String img_name) {
        int iconRes = context.getResources().getIdentifier(img_name, "drawable", context.getPackageName());
        return iconRes;
    }
}
