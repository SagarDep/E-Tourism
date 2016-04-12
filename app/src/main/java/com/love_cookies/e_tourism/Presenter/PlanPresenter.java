package com.love_cookies.e_tourism.Presenter;

import com.love_cookies.e_tourism.Model.Biz.PlanBiz;
import com.love_cookies.e_tourism.View.Interface.IPlanView;

/**
 * Created by xiekun on 2016/4/11 0011.
 *
 * 计划Presenter
 */
public class PlanPresenter {

    private PlanBiz planBiz;
    private IPlanView iPlanView;

    public PlanPresenter(IPlanView iPlanView) {
        planBiz = new PlanBiz();
        this.iPlanView = iPlanView;
    }

}
