package com.callor.movie.service;

import com.callor.movie.config.NaverAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit 을 사용하여 OpenAPI를 조회할때
 * 필요한 연결 Session(Connection) 정보를 만드는 클래스
 */
public class RetrofitClient {

    // 연결 Connection 생성
    private static Retrofit getInstance() {
        return new Retrofit.Builder()
                .baseUrl(NaverAPI.NAVER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    
    // Naver API 연결 Connection을 생성하고
    // DTO Mapper를 만들어 return 하기
    // (이것을 외부에서 연결해서 Naver를 조회한다)
    public static NaverRetrofit getApiClient() {
        return getInstance().create(NaverRetrofit.class);
    }
    
}
