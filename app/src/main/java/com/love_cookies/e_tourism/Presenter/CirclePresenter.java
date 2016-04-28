package com.love_cookies.e_tourism.Presenter;

import com.love_cookies.e_tourism.Model.Bean.CircleBean;
import com.love_cookies.e_tourism.Model.Biz.CircleBiz;
import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.View.Interface.ICircleView;

import java.util.List;

/**
 * Created by xiekun on 2016/4/15 0015.
 *
 * 动态圈Presenter
 */
public class CirclePresenter {

    private CircleBiz circleBiz;
    private ICircleView iCircleView;

    public CirclePresenter(ICircleView iCircleView) {
        circleBiz = new CircleBiz();
        this.iCircleView = iCircleView;
    }

    /**
     * 获取动态圈
     * @param offset
     */
    public void getCircle(int offset) {
        circleBiz.getCircle(offset, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iCircleView.setCircle((List<CircleBean>)result);
            }

            @Override
            public void onFailed(Object msg) {

            }
        });
    }

}
