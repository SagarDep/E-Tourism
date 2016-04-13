package com.love_cookies.e_tourism.View.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.e_tourism.R;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by xiekun on 2016/04/03.
 *
 * APP启动页
 */
@ContentView(R.layout.activity_splash)
public class SplashActivity extends BaseActivity {

	@ViewInject(R.id.splash_bg_iv)
	ImageView splashBgIV;

	private final int SPLASH_DISPLAY_DURATION = 1500;//启动页显示时长
	Looper looper = Looper.myLooper();
	private Handler handler = new Handler(looper);

	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			turnThenFinish(LoginActivity.class);
		}
	};

	/**
	 * 初始化控件
	 * @param savedInstanceState
     */
	@Override
	public void initWidget(Bundle savedInstanceState) {
		x.image().bind(splashBgIV, "assets://splash_bg.png", new ImageOptions.Builder().setFadeIn(true).build());
		handler.postDelayed(runnable, SPLASH_DISPLAY_DURATION);
	}

	/**
	 * 控件点击事件
	 * @param v
     */
	@Override
	public void widgetClick(View v) {

	}

	/**
	 * 改写物理返回键事件
	 * @param keyCode
	 * @param event
     * @return
     */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			handler.removeCallbacks(runnable);
		}
		return super.onKeyDown(keyCode, event);
	}
}
