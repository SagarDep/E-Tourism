package com.love_cookies.e_tourism.View.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Utils.ProgressUtils;
import com.love_cookies.cookie_library.Utils.ToastUtils;
import com.love_cookies.e_tourism.Event.AddPlanEvent;
import com.love_cookies.e_tourism.Presenter.AddPlanPresenter;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.View.Interface.IAddPlanView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import de.greenrobot.event.EventBus;

/**
 * Created by xiekun on 2016/4/14.
 *
 * 添加计划页
 */
@ContentView(R.layout.activity_add_plan)
public class AddPlanActivity extends BaseActivity implements IAddPlanView {

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

    private int[] radioList = {R.id.plan_rb, R.id.note_rb};
    private String type;
    private String[] types = {"计划", "随记"};

    AddPlanPresenter addPlanPresenter = new AddPlanPresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.add_plan_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        rightBtn.setImageResource(R.mipmap.title_btn_publish);
        rightBtn.setOnClickListener(this);
        typeMenu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i_index = 0; i_index < radioList.length; i_index++) {
                    if (radioList[i_index] == checkedId) {
                        type = types[i_index];
                    }
                }
            }
        });
        ((RadioButton)typeMenu.getChildAt(0)).setChecked(true);
    }

    /**
     * 控件的点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.left_btn:
                finish();
                break;
            case R.id.right_btn:
                doAddPlan();
                break;
            default:
                break;
        }
    }

    /**
     * 去添加计划
     */
    @Override
    public void doAddPlan() {
        String content = contentET.getText().toString();
        if (TextUtils.isEmpty(content)) {
            ToastUtils.show(this, R.string.content_hint);
        } else {
            ProgressUtils.showProgress(this, R.string.wait_text);
            addPlanPresenter.doAddPlan(type, content);
        }
    }

    /**
     * 添加成功
     */
    @Override
    public void postSuccess() {
        ProgressUtils.hideProgress();
        EventBus.getDefault().post(new AddPlanEvent());
        finish();
    }

    /**
     * 添加失败
     * @param msg
     */
    @Override
    public void postFailed(String msg) {
        ProgressUtils.hideProgress();
        ToastUtils.show(this, msg);
    }
}
