package com.love_cookies.e_tourism.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.love_cookies.e_tourism.MyApplication;
import com.love_cookies.e_tourism.Event.PostCircleEvent;
import com.love_cookies.e_tourism.Presenter.PostCirclePresenter;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.Utils.PicCompressUtil;
import com.love_cookies.e_tourism.View.Interface.IPostCircleView;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import de.greenrobot.event.EventBus;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

@ContentView(R.layout.activity_post_circle)
public class PostCircleActivity extends BaseActivity implements IPostCircleView {

    private static final int CHOOSE_IMAGE = 0x01;

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
                chooseImg();
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
        Bundle bundle = new Bundle();
        //是否显示调用相机拍照
        bundle.putBoolean(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA, true);
        //最大图片选择数量
        bundle.putInt(MultiImageSelectorActivity.EXTRA_SELECT_COUNT, 1);
        //设置模式 (支持 单选/MultiImageSelectorActivity.MODE_SINGLE 或者 多选/MultiImageSelectorActivity.MODE_MULTI)
        bundle.putInt(MultiImageSelectorActivity.EXTRA_SELECT_MODE, MultiImageSelectorActivity.MODE_SINGLE);
        turnForResult(MultiImageSelectorActivity.class, CHOOSE_IMAGE, bundle);
    }

    /**
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CHOOSE_IMAGE && resultCode == RESULT_OK){
            List<String> path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
            imgPath = PicCompressUtil.getInstance("E-Tourism").save(path.get(0));
            x.image().bind(contentIV, "file://" + imgPath, new ImageOptions.Builder().setFadeIn(true).build());
        }
    }

    /**
     * 去发布
     */
    @Override
    public void doPost() {
        String content = contentET.getText().toString();
        if (TextUtils.isEmpty(content)) {
            Toast.makeText(this, R.string.content_hint, Toast.LENGTH_SHORT).show();
        } else {
            MyApplication.showProgress(this, R.string.wait_text);
            postCirclePresenter.doPost(content, imgPath);
        }
    }

    /**
     * 发布成功
     */
    @Override
    public void postSuccess() {
        MyApplication.hideProgress();
        EventBus.getDefault().post(new PostCircleEvent());
        finish();
    }

    /**
     * 发布失败
     * @param msg
     */
    @Override
    public void postFailed(String msg) {
        MyApplication.hideProgress();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
