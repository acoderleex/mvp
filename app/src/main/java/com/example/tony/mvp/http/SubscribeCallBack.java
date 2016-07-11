package com.example.tony.mvp.http;

/**
 * Created by Tony on 7/8/16.
 */
public interface SubscribeCallBack<M> {

    public void onStart();

    public void onComplete();

    public void onReceiveData(M t);

    public void onError(Throwable e);
}
