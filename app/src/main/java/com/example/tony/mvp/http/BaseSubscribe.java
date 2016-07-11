package com.example.tony.mvp.http;

import android.content.Context;
import android.widget.Toast;

import com.example.tony.mvp.R;
import com.example.tony.mvp.utils.ZYLog;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * Created by Tony on 7/8/16.
 */
public class BaseSubscribe<M> extends Subscriber<M> {

    private Context context;
    private SubscribeCallBack<M> callBack;

    public BaseSubscribe(Context context, SubscribeCallBack<M> callBack) {
        this.context = context;
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
            Toast.makeText(context, context.getResources().getString(R.string.net_timeout), Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(context, context.getResources().getString(R.string.net_connect), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (callBack != null)
            callBack.onError(e);
    }

    @Override
    public void onNext(M m) {
        if (callBack != null)
            callBack.onReceiveData(m);
    }
}
