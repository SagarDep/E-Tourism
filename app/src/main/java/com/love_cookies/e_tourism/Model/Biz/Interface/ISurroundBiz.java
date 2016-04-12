package com.love_cookies.e_tourism.Model.Biz.Interface;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Bean.LocationBean;

/**
 * Created by xiekun on 2016/4/12 0012.
 *
 * 周边逻辑接口
 */
public interface ISurroundBiz {
    void getWeather(String city, CallBack callBack);
    void getSurround(LocationBean locationBean, String keyword, CallBack callBack);
}
