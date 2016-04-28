package com.love_cookies.e_tourism.Model.Biz;

import android.database.Cursor;

import com.love_cookies.e_tourism.Model.Bean.CircleBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.Interface.ICircleBiz;
import com.love_cookies.e_tourism.MyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/4/15 0015.
 *
 * 动态圈逻辑
 */
public class CircleBiz implements ICircleBiz {
    /**
     * 获取动态圈
     * @param offset
     * @param callBack
     */
    @Override
    public void getCircle(int offset, final CallBack callBack) {
        try {
            List<CircleBean> result = new ArrayList<>();
            CircleBean circleBean;
            String sql = "SELECT * FROM circle ORDER BY time DESC LIMIT 10 OFFSET " + (offset * 10);
            Cursor cursor = MyApplication.db.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                circleBean = new CircleBean();
                circleBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                circleBean.setUser_id(cursor.getInt(cursor.getColumnIndex("user_id")));
                circleBean.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                circleBean.setTime(cursor.getString(cursor.getColumnIndex("time")));
                circleBean.setContent(cursor.getString(cursor.getColumnIndex("content")));
                circleBean.setImg(cursor.getString(cursor.getColumnIndex("img")));
                result.add(circleBean);
            }
            cursor.close();
            callBack.onSuccess(result);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
