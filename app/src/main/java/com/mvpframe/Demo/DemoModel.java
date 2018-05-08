package com.mvpframe.Demo;

import android.os.Handler;

/**
 * create by 860115039
 * date      2018/5/7
 * time      15:35
 */
public class DemoModel {

    public static void getData(final String param, final DemoCallback<String> callback){
        // 利用postDelayed方法模拟网络请求数据的耗时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (param){

                    case "normal":
                        callback.onSuccess("根据参数"+param+"的请求网络数据成功");
                        break;

                    case "failure":
                        callback.onFail("请求失败：参数有误");
                        break;

                    case "error":
                        callback.onError();
                        break;
                }
                callback.onComplete();
            }

        },2000);
    }
}
