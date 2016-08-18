package com.example.tony.mvp.presenters;

import android.content.Context;

import com.example.tony.mvp.base.BasePresenter;
import com.example.tony.mvp.http.BaseSubscribe;
import com.example.tony.mvp.http.HttpClient;
import com.example.tony.mvp.http.SubscribeCallBack;
import com.example.tony.mvp.models.ZYLoginRequestBean;
import com.example.tony.mvp.models.ZYLoginResponseBean;
import com.example.tony.mvp.views.login.ZYLoginView;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by Tony on 7/11/16.
 */
public class ZYLoginPresenter extends BasePresenter<ZYLoginView> {

    private EventBus eventBus;

    private BaseSubscribe<ZYLoginResponseBean> subscribe;

    @Inject
    public ZYLoginPresenter(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void doLogin(Context context, ZYLoginRequestBean requestBean) {
        if (isViewAttached())
            getView().showLoading(false);
        subscribe = new BaseSubscribe<>(context, new SubscribeCallBack<ZYLoginResponseBean>() {

            @Override
            public void onComplete() {
                if (isViewAttached())
                    getView().showLoginSuccessful();
            }

            @Override
            public void onReceiveData(ZYLoginResponseBean zyLoginResponseBean) {
                if (isViewAttached())
                    getView().setData(zyLoginResponseBean);
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached())
                    getView().showError(e, false);
            }
        });
        addSubscription(httpApiService.doLogin(requestBean.toString()), subscribe);
    }

}
