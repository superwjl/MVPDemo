package com.tik.mvpdemo.presenter;

import com.tik.mvpdemo.bean.BaseResponse;
import com.tik.mvpdemo.contract.DataContract;
import com.tik.mvpdemo.model.DataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 **/
public class DataPresenter extends DataContract.Presenter {

    private DataModel mModel;

    public DataPresenter() {
        mModel = new DataModel();
    }

    @Override
    public void getData(String appKey) {
        mModel.getData(appKey, new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                mView.onDataSuccess(response.body().getResult().getList());
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                mView.onDataFailure(t.getMessage());
            }
        });
    }
}
