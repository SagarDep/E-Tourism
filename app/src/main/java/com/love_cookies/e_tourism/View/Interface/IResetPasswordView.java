package com.love_cookies.e_tourism.View.Interface;

/**
 * Created by xiekun on 2016/4/13 0013.
 *
 * 修改密码页 View接口
 */
public interface IResetPasswordView {
    /**
     * 去修改密码
     */
    void doResetPassword();

    /**
     * 修改密码失败
     * @param msg
     */
    void resetFailed(String msg);

    /**
     * 跳转到登录页
     */
    void turnToLogin();
}
