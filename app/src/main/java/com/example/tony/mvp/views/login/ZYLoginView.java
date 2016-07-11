package com.example.tony.mvp.views.login;

import com.example.tony.mvp.models.ZYLoginResponseBean;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

/**
 * Created by Tony on 7/11/16.
 */
public interface ZYLoginView extends MvpLceView<ZYLoginResponseBean> {
    public void showLoginSuccessful();
}
