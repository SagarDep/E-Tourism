package com.love_cookies.e_tourism.Model.Biz;

import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Bean.CircleBean;
import com.love_cookies.e_tourism.Model.Bean.UserBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.IPostCircleBiz;
import com.love_cookies.e_tourism.Utils.DateTimeUtil;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by xiekun on 2016/4/15 0015.
 *
 * 发布动态圈逻辑
 */
public class PostCircleBiz implements IPostCircleBiz {
    /**
     * 去发布
     * @param content
     * @param img
     * @param callBack
     */
    @Override
    public void doPost(String content, String img, final CallBack callBack) {
        CircleBean circleBean = new CircleBean();
        UserBean userBean = BmobUser.getCurrentUser(ActivityCollections.getInstance().currentActivity(), UserBean.class);
        circleBean.setUsername(userBean.getUsername());
        circleBean.setNickname(userBean.getNickname());
        circleBean.setTime(DateTimeUtil.getInstance().getCurrentTime());
        circleBean.setContent(content);
        circleBean.setImg(img);
        circleBean.save(ActivityCollections.getInstance().currentActivity(), new SaveListener() {
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
