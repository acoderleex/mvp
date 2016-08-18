package com.example.tony.mvp.http;

import android.content.Context;

import com.example.tony.mvp.global.Global;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求 实例化类
 * <p/>
 * Created by Tony on 7/8/16.
 */
public class HttpClient {

    public HttpApiService httpApiService;
    private static HttpClient instance = null;

    public static HttpClient getInstance(Context context) {
        if (instance == null) {
            instance = new HttpClient(context);
        }
        return instance;
    }

    private HttpClient(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(Global.CONNECTION_TIME, TimeUnit.SECONDS);
        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
        builder.cookieJar(cookieJar);
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Global.BASE_URL)
                .build();
        httpApiService = retrofit.create(HttpApiService.class);
    }
}
