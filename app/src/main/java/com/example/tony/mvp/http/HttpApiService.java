package com.example.tony.mvp.http;

import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Tony on 7/8/16.
 */
public interface HttpApiService {


    /**
     * 登陆接口
     *
     * @param userName
     */
    @POST("login")
    @Headers("Cache-Control: no-cache")
    Observable<HttpResult<Object>> doLogin(@Query("json") String userName);

}
