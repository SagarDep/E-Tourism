package com.love_cookies.e_tourism.View.Interface;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 登录页View接口
 */
public interface ILoginView {
    void doLogin();
    void turnToMain();
    void loginFailed(String msg);
    void autoLogin();
}
