package com.love_cookies.e_tourism.View.Interface;

import com.love_cookies.e_tourism.Model.Bean.CircleBean;

import java.util.List;

/**
 * Created by xiekun on 2016/4/15 0015.
 *
 * 动态圈 View接口
 */
public interface ICircleView {
    /**
     * 获取动态圈
     * @param offset
     */
    void getCircle(int offset);

    /**
     * 设置动态圈
     * @param circles
     */
    void setCircle(List<CircleBean> circles);
}
