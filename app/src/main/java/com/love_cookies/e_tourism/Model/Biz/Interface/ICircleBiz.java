package com.love_cookies.e_tourism.Model.Biz.Interface;


/**
 * Created by xiekun on 2016/4/15 0015.
 *
 * 动态圈逻辑接口
 */
public interface ICircleBiz {
    /**
     * 获取动态圈
     * @param offset
     * @param callBack
     */
    void getCircle(int offset, CallBack callBack);
}
