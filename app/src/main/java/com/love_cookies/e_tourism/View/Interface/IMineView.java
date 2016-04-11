package com.love_cookies.e_tourism.View.Interface;

import com.love_cookies.e_tourism.Model.Bean.UserBean;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 我View接口
 */
public interface IMineView {
    void getUserInfo();
    void setUserInfo(UserBean userBean);
    void doLogout();
    void turnToLogin();
}
