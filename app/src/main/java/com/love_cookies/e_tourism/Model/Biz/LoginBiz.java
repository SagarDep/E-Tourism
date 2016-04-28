package com.love_cookies.e_tourism.Model.Biz;

import android.database.Cursor;

import com.love_cookies.e_tourism.Collections;
import com.love_cookies.e_tourism.Model.Bean.UserBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.Interface.ILoginBiz;
import com.love_cookies.e_tourism.MyApplication;
import com.love_cookies.e_tourism.R;

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
        try {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            Cursor cursor = MyApplication.db.rawQuery(sql, new String[]{username, password});
            if(cursor.moveToFirst()){
                UserBean userBean = new UserBean();
                userBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                userBean.setUsername(cursor.getString(cursor.getColumnIndex("username")));
                userBean.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                callBack.onSuccess(userBean);
            } else {
                callBack.onFailed(Collections.getInstance().currentActivity().getResources().getString(R.string.login_failed_text));
            }
            cursor.close();
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
