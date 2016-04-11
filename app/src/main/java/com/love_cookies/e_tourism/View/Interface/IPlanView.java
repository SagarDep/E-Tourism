package com.love_cookies.e_tourism.View.Interface;

import com.love_cookies.e_tourism.Model.Bean.WeatherBean;

/**
 * Created by xiekun on 2016/4/11 0011.
 *
 * 计划页View接口
 */
public interface IPlanView {
    void getWeather(String city);
    void setWeather(WeatherBean weatherBean);
    void getPlanList();
    void setPlanList();
    void toPlanDetail();
}
