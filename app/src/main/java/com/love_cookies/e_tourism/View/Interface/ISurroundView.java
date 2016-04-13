package com.love_cookies.e_tourism.View.Interface;

import com.love_cookies.e_tourism.Model.Bean.LocationBean;
import com.love_cookies.e_tourism.Model.Bean.SurroundBean;
import com.love_cookies.e_tourism.Model.Bean.WeatherBean;

/**
 * Created by xiekun on 2016/4/12 0012.
 *
 * 周边页 View接口
 */
public interface ISurroundView {
    /**
     * 获取天气
     * @param city
     */
    void getWeather(String city);

    /**
     * 设置天气
     * @param weatherBean
     */
    void setWeather(WeatherBean weatherBean);

    /**
     * 获取周边
     * @param locationBean
     * @param keyword
     */
    void getSurround(LocationBean locationBean, String keyword);

    /**
     * 设置周边
     * @param surroundBean
     */
    void setSurround(SurroundBean surroundBean);
}
