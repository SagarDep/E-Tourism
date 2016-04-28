package com.love_cookies.e_tourism.Model.Biz;

import android.content.Context;

import com.love_cookies.e_tourism.ActivityCollections;
import com.love_cookies.e_tourism.Model.Bean.CircleBean;
import com.love_cookies.e_tourism.Model.Bean.UserBean;
import com.love_cookies.e_tourism.Model.Biz.Interface.CallBack;
import com.love_cookies.e_tourism.Model.Biz.Interface.IPostCircleBiz;
import com.love_cookies.e_tourism.Utils.DateTimeUtil;

import java.io.File;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;

/**
 * Created by xiekun on 2016/4/15 0015.
 *
 * 发布动态圈逻辑
 */
public class PostCircleBiz implements IPostCircleBiz {
    /**
     * 去发布
     * @param content
     * @param img
     * @param callBack
     */
    @Override
    public void doPost(final String content, String img, final CallBack callBack) {
        final Context context = ActivityCollections.getInstance().currentActivity();
        final BmobFile bmobFile = new BmobFile(new File(img));
        bmobFile.uploadblock(context, new UploadFileListener() {
            @Override
            public void onSuccess() {
                CircleBean circleBean = new CircleBean();
                UserBean userBean = BmobUser.getCurrentUser(context, UserBean.class);
                circleBean.setUsername(userBean.getUsername());
                circleBean.setNickname(userBean.getNickname());
                circleBean.setTime(DateTimeUtil.getInstance().getCurrentTime());
                circleBean.setContent(content);
                circleBean.setImg(bmobFile.getFileUrl(context));
                circleBean.save(context, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        callBack.onSuccess(0);
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        callBack.onFailed(s);
                    }
                });
            }

            @Override
            public void onProgress(Integer value) {

            }

            @Override
            public void onFailure(int code, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
