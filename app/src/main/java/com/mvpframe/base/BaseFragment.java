package com.mvpframe.base;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * create by 860115039
 * date      2018/5/7
 * time      16:34
 */
public abstract class BaseFragment<D extends ViewDataBinding, P extends BasePresenter<BaseView>>  extends Fragment implements BaseView {

    private ProgressDialog mProgressDialog;
    /**
     * Activity的DataBinding对象
     */
    protected D mDataBinding;

    protected P mPresenter;


    public abstract int getContentViewId();

    protected abstract void initAllMembersView(Bundle savedInstanceState);

    protected Context mContext;
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        mPresenter = createPresenter();
        mPresenter.attachView(this);
        initTitle();
        initViews();

        this.mContext = getActivity();
        return mDataBinding.getRoot();

    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected abstract P createPresenter();

    protected abstract void initViews();

    protected abstract void initTitle();

    @Override
    public void showLoading() {
        checkActivityAttached();
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }

    }

    @Override
    public void hideLoading() {
        checkActivityAttached();
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    protected boolean isAttachedContext(){
        return mContext != null;
    }

    /**
     * 检查activity连接情况
     */
    public void checkActivityAttached() {
        if (getActivity() == null) {
            throw new ActivityNotAttachedException();
        }
    }

    public static class ActivityNotAttachedException extends RuntimeException {
        public ActivityNotAttachedException() {
            super("Fragment has disconnected from Activity ! - -.");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }
}
