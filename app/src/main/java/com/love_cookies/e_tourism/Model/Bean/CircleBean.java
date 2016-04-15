package com.love_cookies.e_tourism.Model.Bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by xiekun on 2016/4/15 0015.
 *
 * 动态圈实体类
 */
public class CircleBean extends BmobObject {
    private String username;
    private String nickname;
    private String time;
    private String content;
    private String img;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
