package com.love_cookies.e_tourism.Model.Biz;

import com.love_cookies.e_tourism.ActivityCollections;
import com.love_cookies.e_tourism.Model.Bean.UserBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.Interface.IRegisterBiz;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 注册逻辑
 */
public class RegisterBiz implements IRegisterBiz {
    /**
     * 注册
     * @param username
     * @param password
     * @param nickname
     * @param callBack
     */
    @Override
    public void doRegister(String username, String password, String nickname, final CallBack callBack) {
        final UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);
        userBean.setNickname(nickname);
        userBean.signUp(ActivityCollections.getInstance().currentActivity(), new SaveListener() {
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
