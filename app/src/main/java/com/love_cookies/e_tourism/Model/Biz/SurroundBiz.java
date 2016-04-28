package com.love_cookies.e_tourism.Model.Biz;

import com.google.gson.Gson;
import com.love_cookies.e_tourism.Config.AppConfig;
import com.love_cookies.e_tourism.Model.Bean.LocationBean;
import com.love_cookies.e_tourism.Model.Bean.SurroundBean;
import com.love_cookies.e_tourism.Model.Bean.WeatherBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
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
    /**
     * 获取天气
     * @param city
     * @param callBack
     */
    @Override
    public void getWeather(String city, final CallBack callBack) {
        RequestParams requestParams = new RequestParams(AppConfig.WEATHER_API);
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

    /**
     * 获取周边
     * @param locationBean
     * @param keyword
     * @param callBack
     */
    @Override
    public void getSurround(LocationBean locationBean, String keyword, final CallBack callBack) {
        RequestParams requestParams = new RequestParams(AppConfig.SURROUND_API);
        requestParams.addQueryStringParameter("query", keyword);
        requestParams.addQueryStringParameter("location", locationBean.getResult().getLocation().getLat() + "," + locationBean.getResult().getLocation().getLng());
        requestParams.addQueryStringParameter("radius", "1000");
        requestParams.addQueryStringParameter("output", "json");
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                SurroundBean surroundBean = gson.fromJson(result, SurroundBean.class);
                callBack.onSuccess(surroundBean);
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
}
