package com.love_cookies.e_tourism.Presenter;

import com.love_cookies.e_tourism.Model.Bean.PlanBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.PlanBiz;
import com.love_cookies.e_tourism.View.Interface.IPlanView;

import java.util.List;

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

    /**
     * 获取计划列表
     * @param offset
     */
    public void getPlan(int offset) {
        planBiz.getPlan(offset, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iPlanView.setPlan((List<PlanBean>)result);
            }

            @Override
            public void onFailed(Object msg) {

            }
        });
    }

}
