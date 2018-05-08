package com.mvpframe.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class BaseActivity<D extends ViewDataBinding, P extends BasePresenter<BaseView>> extends AppCompatActivity implements BaseView{

    private ProgressDialog mProgressDialog;
    /**
     * Activity的DataBinding对象
     */
    protected D mDataBinding;

    protected P mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);
        mDataBinding = setContentView();
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);

        mPresenter = createPresenter();
        mPresenter.attachView(this);

    }

    /**
     * 通过DataBindingUtils填充页面布局并返回数据绑定对象
     *
     * @return 当前页面数据绑定对象
     */
    protected D setContentView() {
        if (mDataBinding == null)
            return DataBindingUtil.setContentView(this, getLayoutId());
        return mDataBinding;
    }

    protected abstract P createPresenter();

    @LayoutRes
    protected abstract int getLayoutId();

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }
    @Override
    public void showLoading() {
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }
}
