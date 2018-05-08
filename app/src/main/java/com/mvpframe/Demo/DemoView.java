package com.mvpframe.Demo;

import com.mvpframe.base.BaseView;

/**
 * create by 860115039
 * date      2018/5/7
 * time      15:34
 */
public interface DemoView extends BaseView {

    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(String data);


}
