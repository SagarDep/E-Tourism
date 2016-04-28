package com.love_cookies.e_tourism.Presenter;

import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.PostCircleBiz;
import com.love_cookies.e_tourism.View.Interface.IPostCircleView;

/**
 * Created by xiekun on 2016/4/15 0015.
 *
 * 发布动态圈Presenter
 */
public class PostCirclePresenter {

    private PostCircleBiz postCircleBiz;
    private IPostCircleView iPostCircleView;

    public PostCirclePresenter(IPostCircleView iPostCircleView) {
        postCircleBiz = new PostCircleBiz();
        this.iPostCircleView = iPostCircleView;
    }

    /**
     * 去发布
     * @param content
     * @param img
     */
    public void doPost(String content, String img) {
        postCircleBiz.doPost(content, img, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iPostCircleView.postSuccess();
            }

            @Override
            public void onFailed(Object msg) {
                iPostCircleView.postFailed((String)msg);
            }
        });
    }
}
