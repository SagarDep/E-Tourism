package com.love_cookies.e_tourism.View.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.e_tourism.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2016/4/14.
 *
 * 添加计划页
 */
@ContentView(R.layout.activity_add_plan)
public class AddPlanActivity extends BaseActivity {

    @ViewInject(R.id.title_tv)
    TextView titleTV;
    @ViewInject(R.id.left_btn)
    ImageView leftBtn;
    @ViewInject(R.id.right_btn)
    ImageView rightBtn;
    @ViewInject(R.id.type_menu)
    RadioGroup typeMenu;
    @ViewInject(R.id.content_et)
    EditText contentET;

    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.add_plan_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        rightBtn.setImageResource(R.mipmap.title_btn_publish);
        rightBtn.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.left_btn:
                finish();
                break;
            case R.id.right_btn:
                break;
            default:
                break;
        }
    }
}
