package com.mvpframe.base;

/**
 * create by 860115039
 * date      2018/5/8
 * time      9:00
 */
public interface BaseCallback<T> {
    /**
     * 数据请求成功
     * @param data 请求到的数据
     */
    void onSuccess(T data);
    /**
     *  使用网络API接口请求方式时，虽然已经请求成功但是由
     *  于{@code msg}的原因无法正常返回数据。
     */
    void onFail(String msg);
}
