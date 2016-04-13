package com.love_cookies.e_tourism.View.Fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Fragment.BaseFragment;
import com.love_cookies.cookie_library.Widget.LoadAndRefreshView;
import com.love_cookies.e_tourism.Presenter.PlanPresenter;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.View.Interface.IPlanView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 计划 碎片
 */
@ContentView(R.layout.fragment_plan)
public class PlanFragment extends BaseFragment implements IPlanView {

    @ViewInject(R.id.title_tv)
    TextView titleTV;
    @ViewInject(R.id.right_btn)
    ImageView rightBtn;
    @ViewInject(R.id.load_and_refresh_view)
    LoadAndRefreshView loadAndRefreshView;

    PlanPresenter planPresenter = new PlanPresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.plan_text);
        rightBtn.setImageResource(R.mipmap.title_btn_add);
        rightBtn.setOnClickListener(this);
    }

    /**
     * 控件点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.right_btn:
                break;
            default:
                break;
        }
    }

}
