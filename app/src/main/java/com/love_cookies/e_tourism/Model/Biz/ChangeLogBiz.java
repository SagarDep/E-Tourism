package com.love_cookies.e_tourism.Model.Biz;

import android.content.Context;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Bean.ChangeLogBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.IChangeLogBiz;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xiekun on 2016/04/18 0018.
 *
 * 更改日志逻辑
 */
public class ChangeLogBiz implements IChangeLogBiz {
    /**
     * 获取ChangeLog
     * @param context
     * @param callBack
     */
    @Override
    public void getChangeLog(Context context, CallBack callBack) {
        String changeLog;
        try {
            InputStream inputStream = context.getResources().getAssets().open("change_log.json");
            byte [] buffer = new byte[inputStream.available()] ;
            inputStream.read(buffer);
            changeLog = new String(buffer,"utf-8");
            Gson gson = new Gson();
            ChangeLogBean changeLogBean = gson.fromJson(changeLog, ChangeLogBean.class);
            callBack.onSuccess(changeLogBean);
        } catch (IOException e) {
            callBack.onFailed(e.getMessage());
        }
    }
}
