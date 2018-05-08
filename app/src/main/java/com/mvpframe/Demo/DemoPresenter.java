package com.mvpframe.Demo;

import com.mvpframe.base.BasePresenter;

/**
 * create by 860115039
 * date      2018/5/7
 * time      15:34
 */
public class DemoPresenter extends BasePresenter<DemoView> {


    /**
     * 获取网络数据
     * @param params 参数
     */
    public void getData(String params){

        //显示正在加载进度条
        getView().showLoading();
        // 调用Model请求数据
        DemoModel.getData(params, new DemoCallback<String>() {


            @Override
            public void onSuccess(String data) {
                //调用view接口显示数据
                if(isViewAttached()){
                    getView().showData(data);
                }
            }

            @Override
            public void onFail(String msg) {

            }


            @Override
            public void onError() {
                //调用view接口提示请求异常
                if(isViewAttached()){

                }
            }

            @Override
            public void onComplete() {
                // 隐藏正在加载进度条
                if(isViewAttached()){
                    getView().hideLoading();
                }
            }
        });
    }

}
