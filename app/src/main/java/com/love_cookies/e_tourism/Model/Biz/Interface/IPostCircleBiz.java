package com.love_cookies.e_tourism.Model.Biz.Interface;

/**
 * Created by xiekun on 2016/4/15 0015.
 *
 * 发布动态圈逻辑接口
 */
public interface IPostCircleBiz {
    /**
     * 去发布
     * @param content
     * @param img
     * @param callBack
     */
    void doPost(String content, String img, CallBack callBack);
}
