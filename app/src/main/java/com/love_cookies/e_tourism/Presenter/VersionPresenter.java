package com.love_cookies.e_tourism.Presenter;

import android.content.Context;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Bean.ChangeLogBean;
import com.love_cookies.e_tourism.Model.Biz.ChangeLogBiz;
import com.love_cookies.e_tourism.View.Interface.IVersion;


/**
 * Created by xiekun on 2016/04/18 0018.
 *
 * 版本信息Presenter
 */
public class VersionPresenter {

    private ChangeLogBiz changeLogBiz;
    private IVersion iVersion;

    public VersionPresenter(IVersion iVersion) {
        changeLogBiz = new ChangeLogBiz();
        this.iVersion = iVersion;
    }

    /**
     * 获取ChangeLog
     * @param context
     */
    public void getChangeLog(Context context) {
        changeLogBiz.getChangeLog(context, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iVersion.setChangeLog((ChangeLogBean)result);
            }

            @Override
            public void onFailed(Object msg) {
            }
        });
    }

}
