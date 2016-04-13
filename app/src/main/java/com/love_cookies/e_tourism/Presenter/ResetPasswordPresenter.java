package com.love_cookies.e_tourism.Presenter;

import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.e_tourism.View.Interface.IResetPasswordView;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by xiekun on 2016/4/13 0013.
 *
 * 修改密码Presenter
 */
public class ResetPasswordPresenter {

    private IResetPasswordView iResetPasswordView;

    public ResetPasswordPresenter(IResetPasswordView iResetPasswordView) {
        this.iResetPasswordView = iResetPasswordView;
    }

    public void doResetPassword(String old_pwd, String new_pwd) {
        BmobUser.updateCurrentUserPassword(ActivityCollections.getInstance().currentActivity(), old_pwd, new_pwd, new UpdateListener() {
            @Override
            public void onSuccess() {
                BmobUser.logOut(ActivityCollections.getInstance().currentActivity());
                BmobUser.getCurrentUser(ActivityCollections.getInstance().currentActivity());
                iResetPasswordView.turnToLogin();
            }

            @Override
            public void onFailure(int i, String s) {
                iResetPasswordView.resetFailed(s);
            }
        });
    }
}
