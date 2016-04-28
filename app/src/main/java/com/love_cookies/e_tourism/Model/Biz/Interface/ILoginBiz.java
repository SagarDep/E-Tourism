package com.love_cookies.e_tourism.Model.Biz.Interface;


/**
 * Created by xiekun on 2016/4/4.
 *
 * 登录逻辑接口
 */
public interface ILoginBiz {
    /**
     * 登录
     * @param username
     * @param password
     * @param callBack
     */
    void doLogin(String username, String password, CallBack callBack);
}
