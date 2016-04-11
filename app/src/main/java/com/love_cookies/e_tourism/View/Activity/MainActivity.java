package com.love_cookies.e_tourism.View.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Widget.NoScrollViewPager;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.View.Adapter.MainPageAdapter;
import com.love_cookies.e_tourism.View.Fragment.CircleFragment;
import com.love_cookies.e_tourism.View.Fragment.MineFragment;
import com.love_cookies.e_tourism.View.Fragment.NoteFragment;
import com.love_cookies.e_tourism.View.Fragment.PlanFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.content_view)
    NoScrollViewPager contentView;
    @ViewInject(R.id.main_menu)
    RadioGroup mainMenu;

    private int[] radioList = {R.id.plan_btn, R.id.note_btn, R.id.circle_btn, R.id.mine_btn};

    private List<Fragment> fragList = new ArrayList<>();
    private MainPageAdapter mainPageAdapter;

    @Override
    public void initWidget(Bundle savedInstanceState) {
        fragList.add(new PlanFragment());
        fragList.add(new NoteFragment());
        fragList.add(new CircleFragment());
        fragList.add(new MineFragment());
        mainPageAdapter = new MainPageAdapter(getSupportFragmentManager(), fragList);
        contentView.setAdapter(mainPageAdapter);
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

    @Override
    public void widgetClick(View view) {

    }

}
