package com.love_cookies.e_tourism.View.Fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.love_cookies.cookie_library.Fragment.BaseFragment;
import com.love_cookies.e_tourism.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 随记 碎片
 */
@ContentView(R.layout.fragment_note)
public class NoteFragment extends BaseFragment {

    @ViewInject(R.id.title_tv)
    TextView titleTV;

    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.note_text);
    }

    @Override
    public void widgetClick(View view) {

    }
}
