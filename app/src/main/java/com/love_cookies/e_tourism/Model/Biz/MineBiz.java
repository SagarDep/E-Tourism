package com.love_cookies.e_tourism.Model.Biz;

import android.content.Context;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Bean.UserBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.IMineBiz;

import cn.bmob.v3.BmobUser;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 我逻辑
 */
public class MineBiz implements IMineBiz{
    @Override
    public void getUserInfo(Context context, CallBack callBack) {
        UserBean userBean = BmobUser.getCurrentUser(context, UserBean.class);
        callBack.onSuccess(userBean);
    }

    @Override
    public void doLogout(CallBack callBack) {

    }
}
