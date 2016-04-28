package com.love_cookies.e_tourism.Presenter;

import com.love_cookies.e_tourism.Model.Bean.UserBean;
import com.love_cookies.e_tourism.MyApplication;
import com.love_cookies.e_tourism.View.Interface.IMineView;

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
        UserBean userBean = MyApplication.user;
        iMineView.setUserInfo(userBean);
    }

    /**
     * 注销登录
     */
    public void doLogout() {
        MyApplication.setUser(null);
        MyApplication.editor.clear();
        MyApplication.editor.commit();
        iMineView.turnToLogin();
    }
}
