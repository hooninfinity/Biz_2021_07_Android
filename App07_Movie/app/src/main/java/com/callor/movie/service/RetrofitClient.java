package com.callor.movie.service;

import com.callor.movie.config.NaverAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit getInstance() {
        return new Retrofit.Builder()
                .baseUrl(NaverAPI.NAVER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // 인스턴스를 가지고 커넥션을 외부로 보내기 위하여
    public static NaverRetrofit getApiClient() {
        return getInstance().create(NaverRetrofit.class);
    }


}
