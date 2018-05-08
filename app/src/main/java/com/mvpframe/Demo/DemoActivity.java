package com.mvpframe.Demo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import com.mvpframe.R;
import com.mvpframe.base.BaseActivity;
import com.mvpframe.base.BasePresenter;
import com.mvpframe.base.BaseView;

public class DemoActivity extends BaseActivity<DemoActivityBinding,DemoPresenter> implements DemoView{

    @Override
    protected DemoPresenter createPresenter() {
        return new DemoPresenter();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo;
    }

    @Override
    public void showData(String data) {
        mPresenter.getData("normal");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 断开View引用
        mPresenter.detachView();
    }
}
