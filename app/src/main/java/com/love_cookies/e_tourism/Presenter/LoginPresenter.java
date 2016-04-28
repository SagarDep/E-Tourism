package com.love_cookies.e_tourism.Presenter;

import com.love_cookies.e_tourism.Model.Bean.UserBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.LoginBiz;
import com.love_cookies.e_tourism.MyApplication;
import com.love_cookies.e_tourism.View.Interface.ILoginView;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 登录Presenter
 */
public class LoginPresenter {

    private LoginBiz loginBiz;
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        loginBiz = new LoginBiz();
        this.iLoginView = iLoginView;
    }

    /**
     * 去登录
     * @param username
     * @param password
     */
    public void doLogin(final String username, final String password) {
        loginBiz.doLogin(username, password, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                MyApplication.setUser((UserBean)result);
                MyApplication.editor.putString("username", username);
                MyApplication.editor.putString("password", password);
                MyApplication.editor.commit();
                iLoginView.turnToMain();
            }

            @Override
            public void onFailed(Object msg) {
                iLoginView.loginFailed((String)msg);
            }
        });
    }

}
