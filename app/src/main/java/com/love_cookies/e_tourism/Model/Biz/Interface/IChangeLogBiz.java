package com.love_cookies.e_tourism.Model.Biz.Interface;

import android.content.Context;



/**
 * Created by xiekun on 2016/04/18 0018.
 *
 * 更改日志逻辑接口
 */
public interface IChangeLogBiz {
    /**
     * 获取ChangeLog
     * @param context
     * @param callBack
     */
    void getChangeLog(Context context, CallBack callBack);
}
