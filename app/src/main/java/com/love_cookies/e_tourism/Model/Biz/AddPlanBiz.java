package com.love_cookies.e_tourism.Model.Biz;

import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Bean.PlanBean;
import com.love_cookies.e_tourism.Model.Bean.UserBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.IAddPlanBiz;
import com.love_cookies.e_tourism.Utils.DateTimeUtil;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by xiekun on 2016/4/14 0014.
 *
 * 添加计划逻辑
 */
public class AddPlanBiz implements IAddPlanBiz {
    /**
     * 去添加计划
     * @param type
     * @param content
     * @param callBack
     */
    @Override
    public void doAddPlan(String type, String content, final CallBack callBack) {
        PlanBean planBean = new PlanBean();
        UserBean userBean = BmobUser.getCurrentUser(ActivityCollections.getInstance().currentActivity(), UserBean.class);
        planBean.setUsername(userBean.getUsername());
        planBean.setType(type);
        planBean.setTime(DateTimeUtil.getInstance().getCurrentTime());
        planBean.setContent(content);
        planBean.save(ActivityCollections.getInstance().currentActivity(), new SaveListener() {
            @Override
            public void onSuccess() {
                callBack.onSuccess(0);
            }

            @Override
            public void onFailure(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
