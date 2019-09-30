package com.tik.mvpdemo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tik.mvpdemo.adapter.DataAdapter;
import com.tik.mvpdemo.base.BaseActivity;
import com.tik.mvpdemo.bean.ArticleBean;
import com.tik.mvpdemo.contract.DataContract;
import com.tik.mvpdemo.presenter.DataPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<DataPresenter> implements DataContract.View {

    private static final String APP_KEY = "dbb6893ab0913b02724696504181fe39";

    private Button btnGet;
    private RecyclerView recyclerView;

    private DataAdapter mAdapter;

    @Override
    protected int getResId() {
        return R.layout.activity_main;
    }

    @Override
    protected DataPresenter createPresenter() {
        return new DataPresenter();
    }

    @Override
    protected void viewCreated() {
        btnGet = findViewById(R.id.btnGet);
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new DataAdapter(this, new ArrayList<ArticleBean>());
        recyclerView.setAdapter(mAdapter);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading("加载中");
                mPresenter.getData(APP_KEY);
            }
        });
    }

    @Override
    public void onDataSuccess(List<ArticleBean> articleBeanList) {
        hideLoading();
        mAdapter.setNewData(articleBeanList);
    }

    @Override
    public void onDataFailure(String errorMsg) {
        hideLoading();
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}
