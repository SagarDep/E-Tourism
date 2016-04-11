package com.love_cookies.e_tourism.Presenter;

import android.content.Context;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Bean.UserBean;
import com.love_cookies.e_tourism.Model.Biz.MineBiz;
import com.love_cookies.e_tourism.View.Interface.IMineView;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 我Presenter
 */
public class MinePresenter {

    private MineBiz mineBiz;
    private IMineView iMineView;

    public MinePresenter(IMineView iMineView) {
        mineBiz = new MineBiz();
        this.iMineView = iMineView;
    }

    public void getUserInfo(Context context) {
        mineBiz.getUserInfo(context, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iMineView.setUserInfo((UserBean)result);
            }

            @Override
            public void onFailed(Object msg) {

            }
        });
    }
}
