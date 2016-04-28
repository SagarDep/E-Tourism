package com.love_cookies.e_tourism.View.Adapter;

import android.content.Context;

import com.love_cookies.e_tourism.Model.Bean.PlanBean;
import com.love_cookies.e_tourism.R;

import java.util.List;

/**
 * Created by xiekun on 2016/4/14 0014.
 *
 * 计划列表适配器
 */
public class PlanAdapter extends MyAdapter<PlanBean> {

    public PlanAdapter(Context context, List<PlanBean> datas) {
        super(context, R.layout.item_plan_list, datas);
    }

    @Override
    public void convert(MyViewHolder myViewHolder, PlanBean planBean) {
        myViewHolder.setText(R.id.type_tv, planBean.getType());
        myViewHolder.setText(R.id.time_tv, planBean.getTime());
        myViewHolder.setText(R.id.content_tv, planBean.getContent());
    }
}
