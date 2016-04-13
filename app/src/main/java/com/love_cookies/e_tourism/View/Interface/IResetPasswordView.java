package com.love_cookies.e_tourism.View.Interface;

/**
 * Created by xiekun on 2016/4/13 0013.
 *
 * 修改密码页 View接口
 */
public interface IResetPasswordView {
    void doResetPassword();
    void resetFailed(String msg);
    void turnToLogin();
}
