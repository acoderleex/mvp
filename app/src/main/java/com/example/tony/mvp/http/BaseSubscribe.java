package com.example.tony.mvp.http;

import android.app.Application;
import android.widget.Toast;

import com.example.tony.mvp.R;
import com.example.tony.mvp.utils.ZYLog;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * Created by Tony on 7/8/16.
 */
public class BaseSubscribe<T> extends Subscriber<T> {

    private Application application;
    private SubscribeCallBack<T> callBack;

    public BaseSubscribe(Application application, SubscribeCallBack<T> callBack) {
        this.application = application;
        this.callBack = callBack;
    }


    @Override
    public void onCompleted() {
        if (callBack != null)
            callBack.onComplete();
    }

    @Override
    public void onError(Throwable e) {
        ZYLog.showLog("TAG", "====BaseSubscribe====" + e.getMessage());
        if (e instanceof SocketTimeoutException) {
            Toast.makeText(application, application.getResources().getString(R.string.net_timeout), Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(application, application.getResources().getString(R.string.net_connect), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(application, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (callBack != null)
            callBack.onComplete();
    }

    @Override
    public void onNext(T t) {
        if (callBack != null)
            callBack.onReceiveData(t);
    }
}
