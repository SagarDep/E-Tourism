package com.love_cookies.e_tourism.Model.Biz.Interface;

/**
 * Created by xiekun on 2016/4/14 0014.
 *
 * 添加计划逻辑接口
 */
public interface IAddPlanBiz {
    /**
     * 去添加计划
     * @param type
     * @param content
     * @param callBack
     */
    void doAddPlan(String type, String content, CallBack callBack);
}
