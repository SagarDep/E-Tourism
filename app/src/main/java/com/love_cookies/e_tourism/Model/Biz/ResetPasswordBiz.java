package com.love_cookies.e_tourism.Model.Biz;

import android.content.ContentValues;
import android.database.Cursor;

import com.love_cookies.e_tourism.Collections;
import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.Interface.IResetPasswordBiz;
import com.love_cookies.e_tourism.MyApplication;
import com.love_cookies.e_tourism.R;

/**
 * Created by xiekun on 2016/4/28 0028.
 *
 * 修改密码逻辑
 */
public class ResetPasswordBiz implements IResetPasswordBiz {
    /**
     * 去修改密码
     * @param old_pwd
     * @param new_pwd
     * @param callBack
     */
    @Override
    public void doResetPassword(String old_pwd, String new_pwd, CallBack callBack) {
        try {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            Cursor cursor = MyApplication.db.rawQuery(sql, new String[]{MyApplication.user.getUsername() + "", old_pwd});
            if(cursor.moveToFirst()){
                ContentValues values = new ContentValues();
                values.put("password", new_pwd);
                MyApplication.db.update("user", values, "id = ?", new String[]{MyApplication.user.getId() + ""});
                callBack.onSuccess(0);
            } else {
                callBack.onFailed(Collections.getInstance().currentActivity().getResources().getString(R.string.reset_password_failed_tip));
            }
            cursor.close();
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
