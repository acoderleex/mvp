package com.example.tony.mvp.base;

import com.example.tony.mvp.http.BaseSubscribe;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

/**
 * Created by Tony on 7/8/16.
 */
public class BasePresenter<V extends MvpLceView> extends MvpBasePresenter<V> {


    public void cancelSubscription(BaseSubscribe subscriber) {
        //取消网络获取
        if (subscriber != null && !subscriber.isUnsubscribed()) {
            subscriber.unsubscribe();
        }
        subscriber = null;
    }
}
