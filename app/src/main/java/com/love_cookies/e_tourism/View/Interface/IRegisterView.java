package com.love_cookies.e_tourism.View.Interface;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 注册页View接口
 */
public interface IRegisterView {
    void doRegister();
    void turnToLogin();
    void registerFailed(String msg);
}
