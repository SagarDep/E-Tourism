package com.love_cookies.e_tourism.View.Interface;

/**
 * Created by xiekun on 2016/4/14 0014.
 *
 * 添加计划 View接口
 */
public interface IAddPlanView {
    /**
     * 去添加计划
     */
    void doAddPlan();

    /**
     * 添加成功
     */
    void postSuccess();

    /**
     * 添加失败
     * @param msg
     */
    void postFailed(String msg);
}
