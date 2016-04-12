package com.love_cookies.e_tourism.View.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.love_cookies.cookie_library.Adapter.CommonAdapter;
import com.love_cookies.cookie_library.Adapter.CommonViewHolder;
import com.love_cookies.cookie_library.Fragment.BaseFragment;
import com.love_cookies.cookie_library.Widget.ListViewForScrollView;
import com.love_cookies.cookie_library.Widget.LoadAndRefreshView;
import com.love_cookies.e_tourism.Model.Bean.LocationBean;
import com.love_cookies.e_tourism.Model.Bean.SurroundBean;
import com.love_cookies.e_tourism.Model.Bean.WeatherBean;
import com.love_cookies.e_tourism.Presenter.SurroundPresenter;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.Utils.LocationUtil;
import com.love_cookies.e_tourism.Utils.WeatherImgUtil;
import com.love_cookies.e_tourism.View.Interface.ISurroundView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/4/12.
 *
 * 周边 碎片
 */
@ContentView(R.layout.fragment_surround)
public class SurroundFragment extends BaseFragment implements ISurroundView, LoadAndRefreshView.OnHeaderRefreshListener, LoadAndRefreshView.OnFooterRefreshListener {

    @ViewInject(R.id.title_tv)
    TextView titleTV;
    @ViewInject(R.id.load_and_refresh_view)
    LoadAndRefreshView loadAndRefreshView;
    @ViewInject(R.id.weather_iv)
    ImageView weatherIV;
    @ViewInject(R.id.city_tv)
    TextView cityTV;
    @ViewInject(R.id.info_tv)
    TextView infoTV;
    @ViewInject(R.id.temperature_tv)
    TextView temperatureTV;

    @ViewInject(R.id.surround_menu)
    RadioGroup surroundMenu;
    @ViewInject(R.id.surround_list)
    ListViewForScrollView surroundList;

    private SurroundAdapter surroundAdapter;
    private List<SurroundBean.ResultsBean> surroundDatas = new ArrayList<>();

    private String keyword;

    private int[] radioList = {R.id.hotel_btn, R.id.mall_btn, R.id.food_btn, R.id.view_btn};
    private int[] keywords = {R.string.hotel_text, R.string.mall_text, R.string.food_text, R.string.view_text};

    SurroundPresenter surroundPresenter = new SurroundPresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.surround_text);
        getWeather(getCity());
        loadAndRefreshView.setOnHeaderRefreshListener(this);
        loadAndRefreshView.setOnFooterRefreshListener(this);
        surroundMenu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i_index = 0; i_index < radioList.length; i_index++) {
                    if (radioList[i_index] == checkedId) {
                        keyword = getResources().getString(keywords[i_index]);
                        getSurround(LocationUtil.getInstance().locationBean, keyword);
                    }
                }
            }
        });
        ((RadioButton)surroundMenu.getChildAt(0)).setChecked(true);
        surroundAdapter = new SurroundAdapter(getActivity(), surroundDatas);
        surroundList.setAdapter(surroundAdapter);
    }

    @Override
    public void widgetClick(View view) {

    }

    @Override
    public String getCity() {
        LocationBean locationBean = LocationUtil.getInstance().locationBean;
        String city;
        if(locationBean != null) {
            city = locationBean.getResult().getAddressComponent().getCity();
        } else {
            city = "南京市";
        }
        return city;
    }

    @Override
    public void getWeather(String city) {
        surroundPresenter.getWeather(city);
    }

    @Override
    public void setWeather(WeatherBean weatherBean) {
        weatherIV.setImageResource(WeatherImgUtil.getInstance().getWeatherImg(getActivity(), weatherBean.getResult().getData().getRealtime().getWeather().getImg()));
        cityTV.setText(weatherBean.getResult().getData().getRealtime().getCity_name());
        infoTV.setText(weatherBean.getResult().getData().getRealtime().getWeather().getInfo());
        String format = getContext().getResources().getString(R.string.temperature_text);
        String temp = String. format(format , weatherBean.getResult().getData().getRealtime().getWeather().getTemperature());
        temperatureTV.setText(temp);
        onComplete();
    }

    @Override
    public void getSurround(LocationBean locationBean, String keyword) {
        surroundPresenter.getSurround(locationBean, keyword);
    }

    @Override
    public void setSurround(SurroundBean surroundBean) {
        surroundDatas.clear();
        surroundDatas.addAll(surroundBean.getResults());
        surroundAdapter.notifyDataSetChanged();
        onComplete();
    }

    @Override
    public void toDetail() {

    }

    @Override
    public void onFooterRefresh(LoadAndRefreshView view) {
        getSurround(LocationUtil.getInstance().locationBean, keyword);
    }

    @Override
    public void onHeaderRefresh(LoadAndRefreshView view) {
        getWeather(getCity());
        getSurround(LocationUtil.getInstance().locationBean, keyword);
    }

    public void onComplete() {
        final int duration = 3000;
        new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        loadAndRefreshView.onHeaderRefreshComplete();
                        loadAndRefreshView.onFooterRefreshComplete();
                        break;
                }
            }
        }.sendEmptyMessageDelayed(0, duration);
    }

    class SurroundAdapter extends CommonAdapter<SurroundBean.ResultsBean> {

        public SurroundAdapter(Context context, List<SurroundBean.ResultsBean> datas) {
            super(context, R.layout.item_surround_list, datas);
        }

        @Override
        public void convert(CommonViewHolder commonViewHolder, SurroundBean.ResultsBean resultsBean) {
            commonViewHolder.setText(R.id.surround_name, resultsBean.getName());
            commonViewHolder.setText(R.id.surround_address, resultsBean.getAddress());
        }
    }

}
