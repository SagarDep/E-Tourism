package com.love_cookies.e_tourism.Model.Biz;

import android.content.ContentValues;
import android.database.Cursor;

import com.love_cookies.e_tourism.Collections;
import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.Interface.IRegisterBiz;
import com.love_cookies.e_tourism.MyApplication;
import com.love_cookies.e_tourism.R;

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
        try {
            String sql = "SELECT * FROM user WHERE username = ?";
            Cursor cursor = MyApplication.db.rawQuery(sql, new String[]{username});
            if(cursor.moveToFirst()){
                callBack.onFailed(Collections.getInstance().currentActivity().getResources().getString(R.string.re_account_exist));
            } else {
                ContentValues values = new ContentValues();
                values.put("username", username);
                values.put("password", password);
                values.put("nickname", nickname);
                MyApplication.db.insert("user", null, values);
                callBack.onSuccess(0);
            }
            cursor.close();
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
