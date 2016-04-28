package com.love_cookies.e_tourism.View.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.love_cookies.e_tourism.Model.Bean.CircleBean;
import com.love_cookies.e_tourism.R;

import java.util.List;

/**
 * Created by xiekun on 2016/4/15 0015.
 *
 * 动态圈适配器
 */
public class CircleAdapter extends MyAdapter<CircleBean> {

    public CircleAdapter(Context context, List<CircleBean> datas) {
        super(context, R.layout.item_circle_list, datas);
    }

    @Override
    public void convert(MyViewHolder myViewHolder, CircleBean circleBean) {
        myViewHolder.setText(R.id.nickname_tv, circleBean.getNickname());
        myViewHolder.setText(R.id.time_tv, circleBean.getTime());
        myViewHolder.setText(R.id.content_tv, circleBean.getContent());
        if(!TextUtils.isEmpty(circleBean.getImg())) {
            myViewHolder.getView(R.id.content_iv).setVisibility(View.VISIBLE);
            myViewHolder.setImage(R.id.content_iv, circleBean.getImg());
        } else {
            myViewHolder.getView(R.id.content_iv).setVisibility(View.GONE);
        }
    }
}
