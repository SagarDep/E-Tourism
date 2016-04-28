package com.love_cookies.e_tourism.Model.Biz;

import android.content.ContentValues;

import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.Interface.IAddPlanBiz;
import com.love_cookies.e_tourism.MyApplication;
import com.love_cookies.e_tourism.Utils.DateTimeUtil;

/**
 * Created by xiekun on 2016/4/14 0014.
 *
 * 添加计划逻辑
 */
public class AddPlanBiz implements IAddPlanBiz {
    /**
     * 去添加计划
     * @param type
     * @param content
     * @param callBack
     */
    @Override
    public void doAddPlan(String type, String content, final CallBack callBack) {
        try {
            ContentValues values = new ContentValues();
            values.put("user_id", MyApplication.user.getId());
            values.put("type", type);
            values.put("time", DateTimeUtil.getInstance().getCurrentTime());
            values.put("content", content);
            MyApplication.db.insert("plan", null, values);
            callBack.onSuccess(0);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
