package com.example.tony.mvp.http;

import android.content.Context;

import com.example.tony.mvp.global.Global;
import com.example.tony.mvp.http.exceptions.HttpApiException;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 网络请求 实例化类
 * <p>
 * Created by Tony on 7/8/16.
 */
public class HttpClient {

    private HttpApiService httpApiService;
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

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    protected class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.code != Global.HTTPSTATUS_OK) {
                throw new HttpApiException(httpResult.msg);
            }
            return httpResult.data;
        }
    }


    protected <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }
    //-----------------------------------------------网络数据具体方法实现-----------------------------------------------------------------------------------------------------------------

    /**
     * 用户登陆
     *
     * @param subscriber
     * @param gsonPost
     */
    public void doLogin(BaseSubscribe subscriber, Object gsonPost) {
        Gson gson = new Gson();
        Observable<Object> observable = httpApiService.doLogin(gson.toJson(gsonPost))
                .map(new HttpResultFunc<>());
        toSubscribe(observable, subscriber);
    }


}
