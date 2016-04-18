package com.love_cookies.e_tourism.View.Adapter;

import android.content.Context;

import com.love_cookies.cookie_library.Adapter.CommonAdapter;
import com.love_cookies.cookie_library.Adapter.CommonViewHolder;
import com.love_cookies.e_tourism.Model.Bean.ChangeLogBean;
import com.love_cookies.e_tourism.R;

import java.util.List;

/**
 * Created by jk on 2016/4/18 0018.
 *
 * 更改日志适配器
 */
public class ChangeLogAdapter extends CommonAdapter<ChangeLogBean.ChangeLogEntity> {

    public ChangeLogAdapter(Context context, List<ChangeLogBean.ChangeLogEntity> datas) {
        super(context, R.layout.item_change_log_list, datas);
    }

    @Override
    public void convert(CommonViewHolder commonViewHolder, ChangeLogBean.ChangeLogEntity changeLogEntity) {
        commonViewHolder.setText(R.id.version, changeLogEntity.getVersion());
        commonViewHolder.setText(R.id.date, changeLogEntity.getDate());
        commonViewHolder.setText(R.id.description, changeLogEntity.getDescription());
    }
}
