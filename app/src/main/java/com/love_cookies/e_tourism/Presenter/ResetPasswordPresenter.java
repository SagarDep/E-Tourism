package com.love_cookies.e_tourism.Presenter;

import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.ResetPasswordBiz;
import com.love_cookies.e_tourism.MyApplication;
import com.love_cookies.e_tourism.View.Interface.IResetPasswordView;

/**
 * Created by xiekun on 2016/4/13 0013.
 *
 * 修改密码Presenter
 */
public class ResetPasswordPresenter {

    private ResetPasswordBiz resetPasswordBiz;
    private IResetPasswordView iResetPasswordView;

    public ResetPasswordPresenter(IResetPasswordView iResetPasswordView) {
        resetPasswordBiz = new ResetPasswordBiz();
        this.iResetPasswordView = iResetPasswordView;
    }

    /**
     * 去修改密码
     * @param old_pwd
     * @param new_pwd
     */
    public void doResetPassword(String old_pwd, String new_pwd) {
        resetPasswordBiz.doResetPassword(old_pwd, new_pwd, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                MyApplication.setUser(null);
                MyApplication.editor.clear();
                MyApplication.editor.commit();
                iResetPasswordView.turnToLogin();
            }

            @Override
            public void onFailed(Object msg) {
                iResetPasswordView.resetFailed((String) msg);
            }
        });
    }
}
