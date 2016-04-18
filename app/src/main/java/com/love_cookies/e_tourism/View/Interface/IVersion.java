package com.love_cookies.e_tourism.View.Interface;

import com.love_cookies.e_tourism.Model.Bean.ChangeLogBean;

/**
 * Created by xiekun on 2016/04/18 0018.
 *
 * 版本信息页 View接口
 */
public interface IVersion {
    /**
     * 获取版本
     * @return
     */
    String getVersion();

    /**
     * 获取ChangeLog
     */
    void getChangeLog();

    /**
     * 设置ChangeLog
     * @param changeLogBean
     */
    void setChangeLog(ChangeLogBean changeLogBean);
}
