package com.love_cookies.e_tourism.View.Fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Fragment.BaseFragment;
import com.love_cookies.cookie_library.Utils.ToastUtils;
import com.love_cookies.e_tourism.Model.Bean.UserBean;
import com.love_cookies.e_tourism.Presenter.MinePresenter;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.View.Activity.LoginActivity;
import com.love_cookies.e_tourism.View.Activity.ResetPasswordActivity;
import com.love_cookies.e_tourism.View.Activity.VersionActivity;
import com.love_cookies.e_tourism.View.Interface.IMineView;
import com.love_cookies.e_tourism.View.Widget.MineItemView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 我 碎片
 */
@ContentView(R.layout.fragment_mine)
public class MineFragment extends BaseFragment implements IMineView {

    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.username_tv)
    private TextView usernameTV;
    @ViewInject(R.id.reset_password_btn)
    private MineItemView resetPasswordBtn;
    @ViewInject(R.id.version_btn)
    private MineItemView versionBtn;
    @ViewInject(R.id.logout_btn)
    private TextView logoutBtn;

    private MinePresenter minePresenter = new MinePresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.mine_text);
        getUserInfo();
        logoutBtn.setOnClickListener(this);
        usernameTV.setOnClickListener(this);
        resetPasswordBtn.setOnClickListener(this);
        versionBtn.setOnClickListener(this);
    }

    /**
     * 控件点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.username_tv:
                ToastUtils.show(getActivity(), usernameTV.getText().toString());
                break;
            case R.id.reset_password_btn:
                turn(ResetPasswordActivity.class);
                break;
            case R.id.version_btn:
                turn(VersionActivity.class);
                break;
            case R.id.logout_btn:
                doLogout();
                break;
            default:
                break;
        }
    }

    /**
     * 获取用户信息
     */
    @Override
    public void getUserInfo() {
        minePresenter.getUserInfo();
    }

    /**
     * 设置用户信息
     * @param userBean
     */
    @Override
    public void setUserInfo(UserBean userBean) {
        usernameTV.setText(userBean.getNickname());
    }

    /**
     * 注销登录
     */
    @Override
    public void doLogout() {
        minePresenter.doLogout();
    }

    /**
     * 跳转到登录页
     */
    @Override
    public void turnToLogin() {
        turn(LoginActivity.class);
        ActivityCollections.getInstance().finishAllActivity();
    }
}
