package com.love_cookies.e_tourism.View.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/4/11 0011.
 *
 * 主页内容适配器
 */
public class MainPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragList = new ArrayList<>();

    public MainPageAdapter(FragmentManager fm, List<Fragment> fragList) {
        super(fm);
        this.fragList = fragList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragList.get(position);
    }

    @Override
    public int getCount() {
        return fragList.size();
    }

}
