package com.tik.mvpdemo.base;

/**
 *
 **/
public class BasePresenter<V extends IView> implements IPresenter<V> {

    protected V mView;

    @Override
    public void attach(V view) {
        this.mView = view;
    }

    @Override
    public void detach() {
        this.mView = null;
    }
}
