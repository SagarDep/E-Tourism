package com.love_cookies.e_tourism.View.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ProgressUtils;
import com.love_cookies.cookie_library.Utils.ToastUtils;
import com.love_cookies.e_tourism.Presenter.ResetPasswordPresenter;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.View.Interface.IResetPasswordView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2016/04/13.
 *
 * 修改密码页
 */
@ContentView(R.layout.activity_reset_password)
public class ResetPasswordActivity extends BaseActivity implements IResetPasswordView {

    @ViewInject(R.id.title_tv)
    TextView titleTV;
    @ViewInject(R.id.left_btn)
    ImageView leftBtn;
    @ViewInject(R.id.old_password_et)
    EditText oldPasswordET;
    @ViewInject(R.id.new_password_et)
    EditText newPasswordET;
    @ViewInject(R.id.submit_btn)
    TextView submitBtn;

    ResetPasswordPresenter resetPasswordPresenter = new ResetPasswordPresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.mine_item_update_password);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
    }

    /**
     * 控件点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.left_btn:
                finish();
                break;
            case R.id.submit_btn:
                doResetPassword();
                break;
            default:
                break;
        }
    }

    /**
     * 去修改密码
     */
    @Override
    public void doResetPassword() {
        String oldPassword = oldPasswordET.getText().toString();
        String newPassword = newPasswordET.getText().toString();
        if (TextUtils.isEmpty(oldPassword)) {
            ToastUtils.show(this, R.string.old_password_text_hint);
        } else if(TextUtils.isEmpty(newPassword)) {
            ToastUtils.show(this, R.string.new_password_text_hint);
        } else {
            ProgressUtils.showProgress(this, R.string.wait_text);
            resetPasswordPresenter.doResetPassword(oldPassword, newPassword);
        }
    }

    /**
     * 修改密码失败
     * @param msg
     */
    @Override
    public void resetFailed(String msg) {
        ProgressUtils.hideProgress();
        ToastUtils.show(this, msg);
    }

    /**
     * 跳转到登录页
     */
    @Override
    public void turnToLogin() {
        ToastUtils.show(this, R.string.reset_password_success_tip);
        turn(LoginActivity.class);
        ActivityCollections.getInstance().finishAllActivity();
    }

}
