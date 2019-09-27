package com.tik.mvpdemo.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

/**
 *
 **/
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IView{

    protected T mPresenter;
    private ProgressDialog mDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResId());
        mPresenter = createPresenter();
        if (null != mPresenter) {
            mPresenter.attach(this);
        }
        viewCreated();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.detach();
        }
    }

    @Override
    public void showLoading(String message) {
        if (null == mDialog) {
            mDialog = new ProgressDialog(this);
        }
        if (mDialog.isShowing()) {
            mDialog.dismiss();
        }
        mDialog.setMessage(TextUtils.isEmpty(message) ? "加载中" : message);
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        if (null != mDialog && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    protected abstract int getResId();
    protected abstract T createPresenter();
    protected abstract void viewCreated();
}
