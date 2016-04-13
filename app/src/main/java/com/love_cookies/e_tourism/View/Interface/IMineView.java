package com.love_cookies.e_tourism.View.Interface;

import com.love_cookies.e_tourism.Model.Bean.UserBean;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 我View接口
 */
public interface IMineView {
    /**
     * 获取用户信息
     */
    void getUserInfo();

    /**
     * 设置用户信息
     * @param userBean
     */
    void setUserInfo(UserBean userBean);

    /**
     * 注销登录
     */
    void doLogout();

    /**
     * 跳转到登录页
     */
    void turnToLogin();
}
