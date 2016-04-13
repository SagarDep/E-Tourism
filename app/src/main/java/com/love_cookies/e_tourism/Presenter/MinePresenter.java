package com.love_cookies.e_tourism.Presenter;

import com.love_cookies.cookie_library.Application.ActivityCollections;
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

    /**
     * 获取用户信息
     */
    public void getUserInfo() {
        UserBean userBean = BmobUser.getCurrentUser(ActivityCollections.getInstance().currentActivity(), UserBean.class);//获取当前用户
        iMineView.setUserInfo(userBean);
    }

    /**
     * 注销登录
     */
    public void doLogout() {
        BmobUser.logOut(ActivityCollections.getInstance().currentActivity());//清除缓存用户对象
        BmobUser.getCurrentUser(ActivityCollections.getInstance().currentActivity());//现在的currentUser是null了
        iMineView.turnToLogin();
    }
}
