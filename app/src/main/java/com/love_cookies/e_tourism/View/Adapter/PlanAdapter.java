package com.love_cookies.e_tourism.View.Adapter;

import android.content.Context;

import com.love_cookies.cookie_library.Adapter.CommonAdapter;
import com.love_cookies.cookie_library.Adapter.CommonViewHolder;
import com.love_cookies.e_tourism.Model.Bean.PlanBean;
import com.love_cookies.e_tourism.R;

import java.util.List;

/**
 * Created by xiekun on 2016/4/14 0014.
 *
 * 计划列表适配器
 */
public class PlanAdapter extends CommonAdapter<PlanBean> {

    public PlanAdapter(Context context, List<PlanBean> datas) {
        super(context, R.layout.item_plan_list, datas);
    }

    @Override
    public void convert(CommonViewHolder commonViewHolder, PlanBean planBean) {
        commonViewHolder.setText(R.id.type_tv, planBean.getType());
        commonViewHolder.setText(R.id.time_tv, planBean.getTime());
        commonViewHolder.setText(R.id.content_tv, planBean.getContent());
    }
}
