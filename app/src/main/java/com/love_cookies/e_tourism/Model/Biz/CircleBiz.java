package com.love_cookies.e_tourism.Model.Biz;

import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Bean.CircleBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.ICircleBiz;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by xiekun on 2016/4/15 0015.
 *
 * 动态圈逻辑
 */
public class CircleBiz implements ICircleBiz {
    /**
     * 获取动态圈
     * @param offset
     * @param callBack
     */
    @Override
    public void getCircle(int offset, final CallBack callBack) {
        BmobQuery<CircleBean> query = new BmobQuery<>();
        query.setLimit(10);
        query.setSkip(10 * offset);
        query.findObjects(ActivityCollections.getInstance().currentActivity(), new FindListener<CircleBean>() {
            @Override
            public void onSuccess(List<CircleBean> list) {
                callBack.onSuccess(list);
            }

            @Override
            public void onError(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
