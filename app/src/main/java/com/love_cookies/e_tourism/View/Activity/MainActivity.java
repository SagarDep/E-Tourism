package com.love_cookies.e_tourism.View.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.e_tourism.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.text_title)
    TextView titleTV;

    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.app_name);
    }

    @Override
    public void widgetClick(View view) {

    }
}
