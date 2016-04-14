package com.love_cookies.e_tourism.Model.Bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by xiekun on 2016/4/14 0014.
 *
 * 计划实体类
 */
public class PlanBean extends BmobObject {
    private String username;
    private String type;
    private String time;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
