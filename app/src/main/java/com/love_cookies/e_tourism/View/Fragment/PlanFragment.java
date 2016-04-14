package com.love_cookies.e_tourism.View.Fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Fragment.BaseFragment;
import com.love_cookies.cookie_library.Utils.ToastUtils;
import com.love_cookies.cookie_library.Widget.LoadAndRefreshView;
import com.love_cookies.e_tourism.Event.AddPlanEvent;
import com.love_cookies.e_tourism.Model.Bean.PlanBean;
import com.love_cookies.e_tourism.Presenter.PlanPresenter;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.View.Activity.AddPlanActivity;
import com.love_cookies.e_tourism.View.Adapter.PlanAdapter;
import com.love_cookies.e_tourism.View.Interface.IPlanView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

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
    @ViewInject(R.id.plan_list)
    ListView planList;

    PlanPresenter planPresenter = new PlanPresenter(this);

    private PlanAdapter planAdapter;
    private List<PlanBean> planDatas = new ArrayList<>();

    private int offset = 0;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.plan_text);
        rightBtn.setImageResource(R.mipmap.title_btn_add);
        rightBtn.setOnClickListener(this);
        EventBus.getDefault().register(this);
        getPlan(offset);
        planAdapter = new PlanAdapter(getActivity(), planDatas);
        planList.setAdapter(planAdapter);
    }

    /**
     * 控件点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.right_btn:
                turn(AddPlanActivity.class);
                break;
            default:
                break;
        }
    }

    /**
     * 添加计划事件
     * from {@link com.love_cookies.e_tourism.View.Activity.AddPlanActivity#postSuccess}
     * @param addPlanEvent
     */
    public void onEvent(AddPlanEvent addPlanEvent) {
        ToastUtils.show(getActivity(), R.string.add_plan_success_tip);
        getPlan(offset);
    }

    /**
     * 获取计划列表
     * @param offset
     */
    @Override
    public void getPlan(int offset) {
        planPresenter.getPlan(offset);
    }

    /**
     * 设置计划列表
     * @param plans
     */
    @Override
    public void setPlan(List<PlanBean> plans) {
        planDatas.clear();
        planDatas.addAll(plans);
        planAdapter.notifyDataSetChanged();
    }
}
