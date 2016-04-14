package com.love_cookies.e_tourism.View.Interface;

import com.love_cookies.e_tourism.Model.Bean.PlanBean;

import java.util.List;

/**
 * Created by xiekun on 2016/4/11 0011.
 *
 * 计划页View接口
 */
public interface IPlanView {
    /**
     * 获取计划列表
     * @param offset
     */
    void getPlan(int offset);

    /**
     * 设置计划列表
     * @param plans
     */
    void setPlan(List<PlanBean> plans);
}
