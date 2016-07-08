package com.example.tony.mvp.http;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Tony on 7/8/16.
 */
public interface HttpApiService {
    @POST("login")
    Observable<HttpResult<Object>> doLogin(@Query("json") String userName);

}
