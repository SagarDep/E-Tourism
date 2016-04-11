package com.love_cookies.e_tourism.Model.Biz.Interface;

import android.content.Context;

import com.love_cookies.cookie_library.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 我逻辑接口
 */
public interface IMineBiz {
    void getUserInfo(Context context, CallBack callBack);
    void doLogout(CallBack callBack);
}
