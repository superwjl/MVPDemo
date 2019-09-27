package com.tik.mvpdemo.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 **/
public class RetrofitHelper {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://v.juhe.cn";

    public static <K> K createApi(Class<K> cls) {
        return getRetrofit().create(cls);
    }

    static Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (RetrofitHelper.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(buildOkHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }

    private static OkHttpClient buildOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }
}
