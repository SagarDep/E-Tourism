package com.love_cookies.e_tourism.View.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.love_cookies.e_tourism.Event.AddPlanEvent;
import com.love_cookies.e_tourism.Model.Bean.PlanBean;
import com.love_cookies.e_tourism.Presenter.PlanPresenter;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.View.Activity.AddPlanActivity;
import com.love_cookies.e_tourism.View.Adapter.PlanAdapter;
import com.love_cookies.e_tourism.View.Interface.IPlanView;
import com.love_cookies.e_tourism.View.Widget.PullView;

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
public class PlanFragment extends BaseFragment implements IPlanView, PullView.OnHeaderRefreshListener, PullView.OnFooterRefreshListener {

    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.right_btn)
    private ImageView rightBtn;
    @ViewInject(R.id.load_and_refresh_view)
    private PullView pullView;
    @ViewInject(R.id.plan_list)
    private ListView planList;

    private PlanPresenter planPresenter = new PlanPresenter(this);

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
        pullView.setOnHeaderRefreshListener(this);
        pullView.setOnFooterRefreshListener(this);
        planAdapter = new PlanAdapter(getActivity(), planDatas);
        planList.setAdapter(planAdapter);
        getPlan(offset);
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
     * from {@link AddPlanActivity#addSuccess()}
     * @param addPlanEvent
     */
    public void onEvent(AddPlanEvent addPlanEvent) {
        Toast.makeText(getActivity(), R.string.add_plan_success_tip, Toast.LENGTH_SHORT).show();
        offset = 0;
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
        if(offset == 0) {
            planDatas.clear();
        }
        planDatas.addAll(plans);
        planAdapter.notifyDataSetChanged();
        onComplete();
    }

    /**
     * 上拉加载
     * @param view
     */
    @Override
    public void onFooterRefresh(PullView view) {
        getPlan(++offset);
    }

    /**
     * 下拉刷新
     * @param view
     */
    @Override
    public void onHeaderRefresh(PullView view) {
        offset = 0;
        getPlan(offset);
    }

    /**
     * 下拉刷新&上拉加载完成
     */
    public void onComplete() {
        //故意延迟3s
        final int duration = 3000;
        new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        pullView.onHeaderRefreshComplete();
                        pullView.onFooterRefreshComplete();
                        break;
                }
            }
        }.sendEmptyMessageDelayed(0, duration);
    }

}
