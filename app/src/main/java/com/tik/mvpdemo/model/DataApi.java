package com.tik.mvpdemo.model;

import com.tik.mvpdemo.bean.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 **/
public interface DataApi {

    @GET("/weixin/query")
    Call<BaseResponse> getData(@Query("key") String appKey);
}
