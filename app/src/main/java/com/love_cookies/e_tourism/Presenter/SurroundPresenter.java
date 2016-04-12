package com.love_cookies.e_tourism.Presenter;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Bean.WeatherBean;
import com.love_cookies.e_tourism.Model.Biz.SurroundBiz;
import com.love_cookies.e_tourism.View.Interface.ISurroundView;

/**
 * Created by xiekun on 2016/4/12 0012.
 *
 * 周边Presenter
 */
public class SurroundPresenter {

    private SurroundBiz surroundBiz;
    private ISurroundView iSurroundView;

    public SurroundPresenter(ISurroundView iSurroundView) {
        surroundBiz = new SurroundBiz();
        this.iSurroundView = iSurroundView;
    }

    public void getWeather(String city) {
        surroundBiz.getWeather(city, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iSurroundView.setWeather((WeatherBean)result);
            }

            @Override
            public void onFailed(Object msg) {

            }
        });
    }
}
