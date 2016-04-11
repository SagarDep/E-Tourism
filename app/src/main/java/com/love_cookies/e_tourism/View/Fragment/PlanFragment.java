package com.love_cookies.e_tourism.View.Fragment;


import android.os.Bundle;
import android.view.View;

import com.love_cookies.cookie_library.Fragment.BaseFragment;
import com.love_cookies.e_tourism.Model.Bean.WeatherBean;
import com.love_cookies.e_tourism.Presenter.PlanPresenter;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.View.Interface.IPlanView;

import org.xutils.view.annotation.ContentView;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 计划 碎片
 */
@ContentView(R.layout.fragment_plan)
public class PlanFragment extends BaseFragment implements IPlanView {

    PlanPresenter planPresenter = new PlanPresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {

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
