package com.love_cookies.e_tourism.Presenter;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Bean.WeatherBean;
import com.love_cookies.e_tourism.Model.Biz.PlanBiz;
import com.love_cookies.e_tourism.View.Interface.IPlanView;

/**
 * Created by xiekun on 2016/4/11 0011.
 *
 * 计划Presenter
 */
public class PlanPresenter {

    private PlanBiz planBiz;
    private IPlanView iPlanView;

    public PlanPresenter(IPlanView iPlanView) {
        planBiz = new PlanBiz();
        this.iPlanView = iPlanView;
    }

    public void getWeather(String city) {
        planBiz.getWeather(city, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iPlanView.setWeather((WeatherBean)result);
            }

            @Override
            public void onFailed(Object msg) {

            }
        });
    }


    public void getPlanList() {

    }

}
