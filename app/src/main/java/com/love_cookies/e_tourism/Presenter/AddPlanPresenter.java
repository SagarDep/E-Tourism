package com.love_cookies.e_tourism.Presenter;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.AddPlanBiz;
import com.love_cookies.e_tourism.View.Interface.IAddPlanView;

/**
 * Created by jk on 2016/4/14 0014.
 *
 * 添加计划Presenter
 */
public class AddPlanPresenter {

    private AddPlanBiz addPlanBiz;
    private IAddPlanView iAddPlanView;

    public AddPlanPresenter(IAddPlanView iAddPlanView) {
        addPlanBiz = new AddPlanBiz();
        this.iAddPlanView = iAddPlanView;
    }

    /**
     * 去添加计划
     * @param type
     * @param content
     */
    public void doAddPlan(String type, String content) {
        addPlanBiz.doAddPlan(type, content, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iAddPlanView.postSuccess();
            }

            @Override
            public void onFailed(Object msg) {
                iAddPlanView.postFailed((String)msg);
            }
        });
    }
}
