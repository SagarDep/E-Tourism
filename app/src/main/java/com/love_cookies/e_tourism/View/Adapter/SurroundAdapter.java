package com.love_cookies.e_tourism.View.Adapter;

import android.content.Context;

import com.love_cookies.e_tourism.Model.Bean.SurroundBean;
import com.love_cookies.e_tourism.R;

import java.util.List;

/**
 * Created by xiekun on 2016/4/14 0014.
 *
 * 周边列表适配器
 */
public class SurroundAdapter extends MyAdapter<SurroundBean.ResultsBean> {

    public SurroundAdapter(Context context, List<SurroundBean.ResultsBean> datas) {
        super(context, R.layout.item_surround_list, datas);
    }

    @Override
    public void convert(MyViewHolder myViewHolder, SurroundBean.ResultsBean resultsBean) {
        myViewHolder.setText(R.id.surround_name, resultsBean.getName());
        myViewHolder.setText(R.id.surround_address, resultsBean.getAddress());
    }

}
