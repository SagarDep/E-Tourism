package com.love_cookies.e_tourism.Model.Biz;

import android.content.ContentValues;

import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.Interface.IPostCircleBiz;
import com.love_cookies.e_tourism.MyApplication;
import com.love_cookies.e_tourism.Utils.DateTimeUtil;

/**
 * Created by xiekun on 2016/4/15 0015.
 *
 * 发布动态圈逻辑
 */
public class PostCircleBiz implements IPostCircleBiz {
    /**
     * 去发布
     * @param content
     * @param img
     * @param callBack
     */
    @Override
    public void doPost(final String content, String img, final CallBack callBack) {
        try {
            ContentValues values = new ContentValues();
            values.put("user_id", MyApplication.user.getId());
            values.put("nickname", MyApplication.user.getNickname());
            values.put("time", DateTimeUtil.getInstance().getCurrentTime());
            values.put("content", content);
            values.put("img", img);
            MyApplication.db.insert("circle", null, values);
            callBack.onSuccess(0);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
