package com.love_cookies.e_tourism.View.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.love_cookies.cookie_library.Adapter.CommonAdapter;
import com.love_cookies.cookie_library.Adapter.CommonViewHolder;
import com.love_cookies.e_tourism.Model.Bean.CircleBean;
import com.love_cookies.e_tourism.R;

import java.util.List;

/**
 * Created by xiekun on 2016/4/15 0015.
 *
 * 动态圈适配器
 */
public class CircleAdapter extends CommonAdapter<CircleBean> {

    public CircleAdapter(Context context, List<CircleBean> datas) {
        super(context, R.layout.item_circle_list, datas);
    }

    @Override
    public void convert(CommonViewHolder commonViewHolder, CircleBean circleBean) {
        commonViewHolder.setText(R.id.nickname_tv, circleBean.getNickname());
        commonViewHolder.setText(R.id.time_tv, circleBean.getTime());
        commonViewHolder.setText(R.id.content_tv, circleBean.getContent());
        if(!TextUtils.isEmpty(circleBean.getImg())) {
            commonViewHolder.getView(R.id.content_iv).setVisibility(View.VISIBLE);
            commonViewHolder.setImage(R.id.content_iv, circleBean.getImg());
        } else {
            commonViewHolder.getView(R.id.content_iv).setVisibility(View.GONE);
        }
    }
}
