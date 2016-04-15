package com.love_cookies.e_tourism.View.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Utils.ProgressUtils;
import com.love_cookies.cookie_library.Utils.ToastUtils;
import com.love_cookies.e_tourism.Event.PostCircleEvent;
import com.love_cookies.e_tourism.Presenter.PostCirclePresenter;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.View.Interface.IPostCircleView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import de.greenrobot.event.EventBus;

@ContentView(R.layout.activity_post_circle)
public class PostCircleActivity extends BaseActivity implements IPostCircleView {

    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.right_btn)
    private ImageView rightBtn;
    @ViewInject(R.id.content_et)
    private EditText contentET;
    @ViewInject(R.id.content_iv)
    private ImageView contentIV;

    private String imgPath;

    private PostCirclePresenter postCirclePresenter = new PostCirclePresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.post_circle_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        rightBtn.setImageResource(R.mipmap.title_btn_publish);
        rightBtn.setOnClickListener(this);
        contentIV.setOnClickListener(this);
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
            case R.id.right_btn:
                doPost();
                break;
            case R.id.content_iv:
                break;
            default:
                break;
        }
    }

    /**
     * 选择图片
     */
    @Override
    public void chooseImg() {

    }

    /**
     * 去发布
     */
    @Override
    public void doPost() {
        String content = contentET.getText().toString();
        if (TextUtils.isEmpty(content)) {
            ToastUtils.show(this, R.string.content_hint);
        } else {
            ProgressUtils.showProgress(this, R.string.wait_text);
            postCirclePresenter.doPost(content, imgPath);
        }
    }

    /**
     * 发布成功
     */
    @Override
    public void postSuccess() {
        ProgressUtils.hideProgress();
        EventBus.getDefault().post(new PostCircleEvent());
        finish();
    }

    /**
     * 发布失败
     * @param msg
     */
    @Override
    public void postFailed(String msg) {
        ProgressUtils.hideProgress();
        ToastUtils.show(this, msg);
    }
}
