package com.love_cookies.e_tourism.View.Activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Utils.ProgressUtils;
import com.love_cookies.e_tourism.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2016/04/13.
 *
 * 附近的详情页
 */
@ContentView(R.layout.activity_surround_detail)
public class SurroundDetailActivity extends BaseActivity {

    @ViewInject(R.id.title_tv)
    TextView titleTV;
    @ViewInject(R.id.left_btn)
    ImageView leftBtn;
    @ViewInject(R.id.web_view)
    WebView webView;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.detail_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        ProgressUtils.showProgress(this);
        String url = "http://map.baidu.com/mobile/webapp/search/search/qt=inf&uid=" + getIntent().getExtras().getString("uid") + "/?third_party=uri_api";
        webView.loadUrl(url);
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
            default:
                break;
        }
    }

    /**
     * WebChromeClient，用于监听网页加载进度
     */
    public class WebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                ProgressUtils.hideProgress();
            }
            super.onProgressChanged(view, newProgress);
        }
    }

}
