package com.love_cookies.e_tourism.Model.Biz;

import com.love_cookies.e_tourism.Collections;
import com.love_cookies.e_tourism.Model.Bean.UserBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.Interface.ILoginBiz;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 登录逻辑
 */
public class LoginBiz implements ILoginBiz {
    /**
     * 登录
     * @param username
     * @param password
     * @param callBack
     */
    @Override
    public void doLogin(String username, String password, final CallBack callBack) {
        final UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);
        userBean.login(Collections.getInstance().currentActivity(), new SaveListener() {
            @Override
            public void onSuccess() {
                callBack.onSuccess(userBean);
            }

            @Override
            public void onFailure(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
