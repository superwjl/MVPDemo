package com.tik.mvpdemo.view;


import com.tik.mvpdemo.base.IView;
import com.tik.mvpdemo.bean.ArticleBean;

import java.util.List;

public interface DataView extends IView {

    void onDataSuccess(List<ArticleBean> articleBeanList);

    void onDataFailure(String errorMsg);
}
