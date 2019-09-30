package com.tik.mvpdemo.contract;

import com.tik.mvpdemo.base.BasePresenter;
import com.tik.mvpdemo.base.IView;
import com.tik.mvpdemo.bean.ArticleBean;
import com.tik.mvpdemo.bean.BaseResponse;

import java.util.List;

import retrofit2.Callback;

/**
 *
 **/
public interface DataContract {

    interface View extends IView {

        void onDataSuccess(List<ArticleBean> articleBeanList);

        void onDataFailure(String errorMsg);
    }

    interface Model {
        void getData(String appKey, Callback<BaseResponse> callback);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getData(String appKey);
    }

}
