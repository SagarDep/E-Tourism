package com.love_cookies.e_tourism.View.Fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Fragment.BaseFragment;
import com.love_cookies.e_tourism.Model.Bean.LocationBean;
import com.love_cookies.e_tourism.Model.Bean.WeatherBean;
import com.love_cookies.e_tourism.Presenter.PlanPresenter;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.Utils.LocationUtil;
import com.love_cookies.e_tourism.Utils.WeatherImgUtil;
import com.love_cookies.e_tourism.View.Interface.IPlanView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 计划 碎片
 */
@ContentView(R.layout.fragment_plan)
public class PlanFragment extends BaseFragment implements IPlanView {

    @ViewInject(R.id.weather_iv)
    ImageView weatherIV;
    @ViewInject(R.id.city_tv)
    TextView cityTV;
    @ViewInject(R.id.info_tv)
    TextView infoTV;
    @ViewInject(R.id.temperature_tv)
    TextView temperatureTV;

    PlanPresenter planPresenter = new PlanPresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {
        LocationBean locationBean = LocationUtil.getInstance().locationBean;
        String city;
        if(locationBean != null) {
            city = locationBean.getResult().getAddressComponent().getCity();
        } else {
            city = "南京市";
        }
        getWeather(city);
    }

    @Override
    public void widgetClick(View view) {

    }

    @Override
    public void getWeather(String city) {
        planPresenter.getWeather(city);
    }

    @Override
    public void setWeather(WeatherBean weatherBean) {
        weatherIV.setImageResource(WeatherImgUtil.getInstance().getWeatherImg(getActivity(), weatherBean.getResult().getData().getRealtime().getWeather().getImg()));
        cityTV.setText(weatherBean.getResult().getData().getRealtime().getCity_name());
        infoTV.setText(weatherBean.getResult().getData().getRealtime().getWeather().getInfo());
        String format = getContext().getResources().getString(R.string.temperature_text);
        String temp = String. format(format , weatherBean.getResult().getData().getRealtime().getWeather().getTemperature());
        temperatureTV.setText(temp);
    }

    @Override
    public void getPlanList() {

    }

    @Override
    public void setPlanList() {

    }

    @Override
    public void toPlanDetail() {

    }

}
