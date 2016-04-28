package com.love_cookies.e_tourism.Model.Biz;

import android.database.Cursor;

import com.love_cookies.e_tourism.Model.Bean.PlanBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.Interface.IPlanBiz;
import com.love_cookies.e_tourism.MyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/4/11 0011.
 *
 * 计划逻辑
 */
public class PlanBiz implements IPlanBiz {
    /**
     * 获取计划列表
     * @param offset
     */
    @Override
    public void getPlan(int offset, final CallBack callBack) {
        try {
            List<PlanBean> result = new ArrayList<>();
            PlanBean planBean;
            String sql = "SELECT * FROM plan ORDER BY time DESC LIMIT 10 OFFSET " + (offset * 10);
            Cursor cursor = MyApplication.db.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                planBean = new PlanBean();
                planBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                planBean.setUser_id(cursor.getInt(cursor.getColumnIndex("user_id")));
                planBean.setType(cursor.getString(cursor.getColumnIndex("type")));
                planBean.setTime(cursor.getString(cursor.getColumnIndex("time")));
                planBean.setContent(cursor.getString(cursor.getColumnIndex("content")));
                result.add(planBean);
            }
            cursor.close();
            callBack.onSuccess(result);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
