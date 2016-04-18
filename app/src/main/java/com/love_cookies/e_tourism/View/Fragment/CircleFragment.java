package com.love_cookies.e_tourism.View.Fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Fragment.BaseFragment;
import com.love_cookies.cookie_library.Utils.ToastUtils;
import com.love_cookies.cookie_library.Widget.LoadAndRefreshView;
import com.love_cookies.e_tourism.Event.PostCircleEvent;
import com.love_cookies.e_tourism.Model.Bean.CircleBean;
import com.love_cookies.e_tourism.Presenter.CirclePresenter;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.View.Activity.PostCircleActivity;
import com.love_cookies.e_tourism.View.Adapter.CircleAdapter;
import com.love_cookies.e_tourism.View.Interface.ICircleView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 动态圈 碎片
 */
@ContentView(R.layout.fragment_circle)
public class CircleFragment extends BaseFragment implements ICircleView, LoadAndRefreshView.OnHeaderRefreshListener, LoadAndRefreshView.OnFooterRefreshListener {

    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.right_btn)
    private ImageView rightBtn;
    @ViewInject(R.id.load_and_refresh_view)
    private LoadAndRefreshView loadAndRefreshView;
    @ViewInject(R.id.circle_list)
    private ListView circleList;

    private CircleAdapter circleAdapter;
    private List<CircleBean> circleDatas = new ArrayList<>();

    private int offset = 0;

    private CirclePresenter circlePresenter = new CirclePresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.circle_text);
        rightBtn.setImageResource(R.mipmap.title_btn_publish);
        rightBtn.setOnClickListener(this);
        EventBus.getDefault().register(this);
        loadAndRefreshView.setOnHeaderRefreshListener(this);
        loadAndRefreshView.setOnFooterRefreshListener(this);
        circleAdapter = new CircleAdapter(getActivity(), circleDatas);
        circleList.setAdapter(circleAdapter);
        getCircle(offset);
    }

    /**
     * 控件点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.right_btn:
                turn(PostCircleActivity.class);
                break;
            default:
                break;
        }
    }

    /**
     * 添加计划事件
     * from {@link PostCircleActivity#postSuccess()}
     * @param postCircleEvent
     */
    public void onEvent(PostCircleEvent postCircleEvent) {
        ToastUtils.show(getActivity(), R.string.post_circle_success_tip);
        offset = 0;
        getCircle(offset);
    }

    /**
     * 获取动态圈
     * @param offset
     */
    @Override
    public void getCircle(int offset) {
        circlePresenter.getCircle(offset);
    }

    /**
     * 设置动态圈
     * @param circles
     */
    @Override
    public void setCircle(List<CircleBean> circles) {
        if(offset == 0) {
            circleDatas.clear();
        }
        circleDatas.addAll(circles);
        circleAdapter.notifyDataSetChanged();
        onComplete();
    }

    /**
     * 上拉加载
     * @param view
     */
    @Override
    public void onFooterRefresh(LoadAndRefreshView view) {
        getCircle(++offset);
    }

    /**
     * 下拉刷新
     * @param view
     */
    @Override
    public void onHeaderRefresh(LoadAndRefreshView view) {
        offset = 0;
        getCircle(offset);
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
                        loadAndRefreshView.onHeaderRefreshComplete();
                        loadAndRefreshView.onFooterRefreshComplete();
                        break;
                }
            }
        }.sendEmptyMessageDelayed(0, duration);
    }

}
