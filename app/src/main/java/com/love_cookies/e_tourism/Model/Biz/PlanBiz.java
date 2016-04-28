package com.love_cookies.e_tourism.Model.Biz;

import com.love_cookies.e_tourism.Collections;
import com.love_cookies.e_tourism.Model.Bean.PlanBean;
import com.love_cookies.e_tourism.Model.Bean.UserBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.Interface.IPlanBiz;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by xiekun on 2016/4/11 0011.
 *
 * 计划逻辑
 */
public class PlanBiz implements IPlanBiz {
    /**
     * 获取计划列表
     * @param offset
     */
    @Override
    public void getPlan(int offset, final CallBack callBack) {
        BmobQuery<PlanBean> query = new BmobQuery<>();
        UserBean userBean = BmobUser.getCurrentUser(Collections.getInstance().currentActivity(), UserBean.class);
        query.addWhereEqualTo("username", userBean.getUsername());
        query.setLimit(10);
        query.setSkip(10 * offset);
        query.findObjects(Collections.getInstance().currentActivity(), new FindListener<PlanBean>() {
            @Override
            public void onSuccess(List<PlanBean> list) {
                callBack.onSuccess(list);
            }

            @Override
            public void onError(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
