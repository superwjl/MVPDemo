package com.tik.mvpdemo.model;

import com.tik.mvpdemo.bean.BaseResponse;
import com.tik.mvpdemo.contract.DataContract;
import com.tik.mvpdemo.http.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;

/**
 *
 **/
public class DataModel implements DataContract.Model {

    private DataApi mApi;

    public DataModel() {
        mApi = RetrofitHelper.createApi(DataApi.class);
    }

    @Override
    public void getData(String appKey, Callback<BaseResponse> callback) {
        Call<BaseResponse> call = mApi.getData(appKey);
        call.enqueue(callback);
    }
}
