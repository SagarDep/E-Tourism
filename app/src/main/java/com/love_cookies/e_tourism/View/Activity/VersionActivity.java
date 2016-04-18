package com.love_cookies.e_tourism.View.Activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.e_tourism.Model.Bean.ChangeLogBean;
import com.love_cookies.e_tourism.Presenter.VersionPresenter;
import com.love_cookies.e_tourism.R;
import com.love_cookies.e_tourism.View.Adapter.ChangeLogAdapter;
import com.love_cookies.e_tourism.View.Interface.IVersion;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xiekun on 2016/04/18 0018.
 * <p/>
 * 版本信息页
 */
@ContentView(R.layout.activity_version)
public class VersionActivity extends BaseActivity implements IVersion {

    @ViewInject(R.id.title_tv)
    private TextView pageTitle;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.version_tv)
    private TextView versionText;
    @ViewInject(R.id.change_log_list)
    private ListView changeLogList;

    private ChangeLogAdapter changeLogAdapter;
    private List<ChangeLogBean.ChangeLogEntity> changeLogDatas = new ArrayList<>();

    private VersionPresenter versionPresenter = new VersionPresenter(this);

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(R.string.version_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        versionText.setText(getVersion());
        changeLogAdapter = new ChangeLogAdapter(this, changeLogDatas);
        changeLogList.setAdapter(changeLogAdapter);
        getChangeLog();
    }

    /**
     * 控件点击事件
     *
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
     * 获取版本
     *
     * @return
     */
    @Override
    public String getVersion() {
        PackageManager manager = this.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(this.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return " V " + info.versionName;
    }

    /**
     * 获取ChangeLog
     */
    @Override
    public void getChangeLog() {
        versionPresenter.getChangeLog(this);
    }

    /**
     * 设置ChangeLog
     *
     * @param changeLogBean
     */
    @Override
    public void setChangeLog(ChangeLogBean changeLogBean) {
        changeLogDatas.clear();
        changeLogDatas.addAll(changeLogBean.getChange_log());
        changeLogAdapter.notifyDataSetChanged();
    }

}
