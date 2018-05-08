package com.mvpframe.base;

import android.content.Context;

/**
 * create by 860115039
 * date      2018/5/7
 * time      16:14
 */
public interface BaseView {
    /**
     * 显示正在加载view
     */
    void showLoading();

    /**
     * 关闭正在加载view
     */
    void hideLoading();

    /**
     * 显示提示
     * @param msg
     */
    void showToast(String msg);

    /**
     * 获取上下文
     * @return 上下文
     */
    Context getContext();
}
