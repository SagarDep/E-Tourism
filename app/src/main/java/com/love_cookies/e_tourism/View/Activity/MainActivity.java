package com.love_cookies.e_tourism.View.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;
import com.love_cookies.cookie_library.Widget.NoScrollViewPager;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.View.Adapter.MainPageAdapter;
import com.love_cookies.e_tourism.View.Fragment.CircleFragment;
import com.love_cookies.e_tourism.View.Fragment.MineFragment;
import com.love_cookies.e_tourism.View.Fragment.PlanFragment;
import com.love_cookies.e_tourism.View.Fragment.SurroundFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.content_view)
    private NoScrollViewPager contentView;
    @ViewInject(R.id.main_menu)
    private RadioGroup mainMenu;

    private int[] radioList = {R.id.surround_btn, R.id.plan_btn, R.id.circle_btn, R.id.mine_btn};

    private List<Fragment> fragList = new ArrayList<>();
    private MainPageAdapter mainPageAdapter;

    private long exitTime;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        fragList.add(new SurroundFragment());
        fragList.add(new PlanFragment());
        fragList.add(new CircleFragment());
        fragList.add(new MineFragment());
        mainPageAdapter = new MainPageAdapter(getSupportFragmentManager(), fragList);
        contentView.setAdapter(mainPageAdapter);
        contentView.setOffscreenPageLimit(4);
        mainMenu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i_index = 0; i_index < radioList.length; i_index++) {
                    if (radioList[i_index] == checkedId) {
                        contentView.setCurrentItem(i_index, false);
                    }
                }
            }
        });
        ((RadioButton)mainMenu.getChildAt(0)).setChecked(true);
    }

    /**
     * 控件点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {

    }

    /**
     * 点两次返回退出程序
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000)
            {
                ToastUtils.show(getApplicationContext(), R.string.exit_tip);
                exitTime = System.currentTimeMillis();
            } else {
                ActivityCollections.getInstance().finishAllActivity();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
