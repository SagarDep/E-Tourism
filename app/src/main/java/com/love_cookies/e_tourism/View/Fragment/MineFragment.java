package com.love_cookies.e_tourism.View.Fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.love_cookies.cookie_library.Fragment.BaseFragment;
import com.love_cookies.e_tourism.Model.Bean.UserBean;
import com.love_cookies.e_tourism.Presenter.MinePresenter;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.View.Interface.IMineView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 我 碎片
 */
@ContentView(R.layout.fragment_mine)
public class MineFragment extends BaseFragment implements IMineView {

    @ViewInject(R.id.username_tv)
    TextView usernameTV;

    MinePresenter minePresenter = new MinePresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {
        getUserInfo();
    }

    @Override
    public void widgetClick(View view) {

    }

    @Override
    public void getUserInfo() {
        minePresenter.getUserInfo(getActivity());
    }

    @Override
    public void setUserInfo(UserBean userBean) {
        usernameTV.setText(userBean.getNickname());
    }

    @Override
    public void doLogout() {

    }
}
