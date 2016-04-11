package com.love_cookies.e_tourism.View.Widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.love_cookies.e_tourism.R;
import com.zhy.autolayout.AutoFrameLayout;

/**
 * Created by xiekun on 2016/4/11 0011.
 *
 * 我页面里的条目
 */
public class MineItemView extends AutoFrameLayout {

    TextView itemTitle;

    public MineItemView(Context context) {
        super(context);
    }

    public MineItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context, attrs);
    }

    public MineItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context, attrs);
    }

    public MineItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initLayout(context, attrs);
    }

    private void initLayout(Context context, AttributeSet attrs) {
        LayoutInflater factory = LayoutInflater.from(context);
        factory.inflate(R.layout.view_mine_item, this);

        itemTitle = (TextView)findViewById(R.id.item_title);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.MineItem);

        CharSequence title = typedArray.getText(R.styleable.MineItem_Title);
        itemTitle.setText(title);
    }

}
