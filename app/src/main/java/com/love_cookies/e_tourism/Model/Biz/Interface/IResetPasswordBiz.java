package com.love_cookies.e_tourism.Model.Biz.Interface;

/**
 * Created by xiekun on 2016/4/28 0028.
 *
 * 修改密码逻辑接口
 */
public interface IResetPasswordBiz {
    /**
     * 去修改密码
     * @param old_pwd
     * @param new_pwd
     * @param callBack
     */
    void doResetPassword(String old_pwd, String new_pwd, CallBack callBack);
}
