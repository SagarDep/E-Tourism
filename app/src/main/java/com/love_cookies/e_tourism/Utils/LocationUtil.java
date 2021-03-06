package com.love_cookies.e_tourism.Utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.google.gson.Gson;
import com.love_cookies.e_tourism.Config.AppConfig;
import com.love_cookies.e_tourism.Model.Bean.LocationBean;
import com.love_cookies.e_tourism.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by xiekun on 2016/4/11 0011.
 * <p/>
 * 获取定位
 */
public class LocationUtil {

    private LocationManager locationManager;
    private String provider;
    private static Location location;

    private Context mContext;
    public LocationBean locationBean;

    private static LocationUtil instance;

    /**
     * LocationUtil
     *
     * @return LocationUtil
     */
    public static LocationUtil getInstance() {
        if (instance == null) {
            instance = new LocationUtil();
        }
        return instance;
    }

    /**
     * 获取定位
     */
    public void getLocation(Context context) {
        mContext = context;
        locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        List<String> providerList = locationManager.getProviders(true);

        //默认南京-仙鹤门
        LocationBean locationBean = new LocationBean();
        LocationBean.ResultEntity resultEntity = new LocationBean.ResultEntity();
        LocationBean.ResultEntity.LocationEntity locationEntity = new LocationBean.ResultEntity.LocationEntity();
        LocationBean.ResultEntity.AddressComponentEntity addressComponentEntity = new LocationBean.ResultEntity.AddressComponentEntity();
        addressComponentEntity.setCity("南京");
        locationEntity.setLat(32.088288);
        locationEntity.setLng(118.893389);
        resultEntity.setLocation(locationEntity);
        resultEntity.setAddressComponent(addressComponentEntity);
        locationBean.setResult(resultEntity);
        this.locationBean = locationBean;

        if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
            provider = LocationManager.NETWORK_PROVIDER;
        } else if (providerList.contains(LocationManager.GPS_PROVIDER)) {
            provider = LocationManager.GPS_PROVIDER;
        } else {
            Toast.makeText(context, R.string.no_provider_to_user, Toast.LENGTH_SHORT).show();
            return;
        }

        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, R.string.no_permissions_for_location, Toast.LENGTH_SHORT).show();
            return;
        }

        location = locationManager.getLastKnownLocation(provider);
        if (location != null) {
            reLocation(location);
        }
        locationManager.requestLocationUpdates(provider, 5000, 1, locationListener);
    }

    /**
     * 定位改变监听
     */
    public LocationListener locationListener = new LocationListener() {
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onLocationChanged(Location location) {
            // 更新当前设备的位置信息
            reLocation(location);
        }
    };

    /**
     * 反地理编码
     *
     * @param location
     */
    public void reLocation(Location location) {
        RequestParams requestParams = new RequestParams(AppConfig.RE_LOCATION_API);
        requestParams.addQueryStringParameter("output", "json");
        requestParams.addQueryStringParameter("location", location.getLatitude() + "," + location.getLongitude());
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                locationBean = gson.fromJson(result, LocationBean.class);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                closeLocation();
            }
        });
    }

    /**
     * 关闭定位
     */
    public void closeLocation() {
        if (this.locationManager != null) {
            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            this.locationManager.removeUpdates(locationListener);
            this.locationManager = null;
        }
        if (locationListener != null) {
            locationListener = null;
        }
    }

}
