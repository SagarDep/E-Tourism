package com.love_cookies.e_tourism.View.Interface;

/**
 * Created by xiekun on 2016/4/15 0015.
 *
 * 发布动态圈 View接口
 */
public interface IPostCircleView {

    /**
     * 选择图片
     */
    void chooseImg();

    /**
     * 去发布
     */
    void doPost();

    /**
     * 发布成功
     */
    void postSuccess();

    /**
     * 发布失败
     * @param msg
     */
    void postFailed(String msg);
}
