package com.love_cookies.e_tourism.View.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.love_cookies.e_tourism.Collections;
import com.love_cookies.e_tourism.MyApplication;
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
    private TextView titleTV;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.old_password_et)
    private EditText oldPasswordET;
    @ViewInject(R.id.new_password_et)
    private EditText newPasswordET;
    @ViewInject(R.id.submit_btn)
    private TextView submitBtn;

    private ResetPasswordPresenter resetPasswordPresenter = new ResetPasswordPresenter(this);

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
            Toast.makeText(this, R.string.old_password_text_hint, Toast.LENGTH_SHORT).show();
        } else if(TextUtils.isEmpty(newPassword)) {
            Toast.makeText(this, R.string.new_password_text_hint, Toast.LENGTH_SHORT).show();
        } else {
            MyApplication.showProgress(this, R.string.wait_text);
            resetPasswordPresenter.doResetPassword(oldPassword, newPassword);
        }
    }

    /**
     * 修改密码失败
     * @param msg
     */
    @Override
    public void resetFailed(String msg) {
        MyApplication.hideProgress();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 跳转到登录页
     */
    @Override
    public void turnToLogin() {
        Toast.makeText(this, R.string.reset_password_success_tip, Toast.LENGTH_SHORT).show();
        turn(LoginActivity.class);
        Collections.getInstance().finishAllActivity();
    }

}
