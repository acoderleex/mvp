package com.example.tony.mvp.base;

import com.example.tony.mvp.ZYApplication;
import com.example.tony.mvp.global.Global;
import com.example.tony.mvp.http.HttpApiService;
import com.example.tony.mvp.http.HttpClient;
import com.example.tony.mvp.http.HttpResult;
import com.example.tony.mvp.http.exceptions.HttpApiException;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Tony on 7/8/16.
 */
public class BasePresenter<V extends MvpLceView> extends MvpBasePresenter<V> {


    private CompositeSubscription mCompositeSubscription;

    public HttpApiService httpApiService = HttpClient.getInstance(ZYApplication.getInstance()).httpApiService;

    public void cancelSubscription() {
        //取消网络获取
        if (mCompositeSubscription != null && !mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable.map(new HttpResultFunc())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
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

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance) {
            cancelSubscription();
        }
    }

}
