package com.love_cookies.e_tourism.Model.Biz;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Bean.LocationBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.IPlanBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiekun on 2016/4/11 0011.
 *
 * 计划逻辑
 */
public class PlanBiz implements IPlanBiz {

    @Override
    public void getWeather(String city, CallBack callBack) {

    }

    @Override
    public void getPlanList(CallBack callBack) {

    }

}
