package com.love_cookies.e_tourism.Presenter;

import android.content.Context;

import com.love_cookies.e_tourism.Model.Bean.UserBean;
import com.love_cookies.e_tourism.View.Interface.IMineView;

import cn.bmob.v3.BmobUser;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 我Presenter
 */
public class MinePresenter {

    private IMineView iMineView;

    public MinePresenter(IMineView iMineView) {
        this.iMineView = iMineView;
    }

    public void getUserInfo(Context context) {
        UserBean userBean = BmobUser.getCurrentUser(context, UserBean.class);//获取当前用户
        iMineView.setUserInfo(userBean);
    }

    public void doLogout(Context context) {
        BmobUser.logOut(context);//清除缓存用户对象
        BmobUser currentUser = BmobUser.getCurrentUser(context);//现在的currentUser是null了
        iMineView.turnToLogin();
    }
}
