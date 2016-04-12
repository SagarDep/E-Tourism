package com.love_cookies.e_tourism.Model.Biz;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_tourism.Config.AppConfig;
import com.love_cookies.e_tourism.Model.Bean.WeatherBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.ISurroundBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiekun on 2016/4/12 0012.
 *
 * 周边逻辑
 */
public class SurroundBiz implements ISurroundBiz {
    @Override
    public void getWeather(String city, final CallBack callBack) {
        RequestParams requestParams = new RequestParams(AppConfig.WEATHER_URL);
        requestParams.addQueryStringParameter("cityname", city);
        requestParams.addQueryStringParameter("key", AppConfig.APPKEY);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                WeatherBean weatherBean = gson.fromJson(result, WeatherBean.class);
                callBack.onSuccess(weatherBean);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void getLocation(String keyword, CallBack callBack) {

    }
}
