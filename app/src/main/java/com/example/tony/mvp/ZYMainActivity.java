package com.example.tony.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.tony.mvp.base.BaseActivity;
import com.example.tony.mvp.utils.ActivityUtils;
import com.example.tony.mvp.views.login.ZYLoginFragment;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * Created by Tony on 7/7/16.
 */
public class ZYMainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), ZYLoginFragment.newInstance("id"), R.id.contentFrame);
    }

    @NonNull
    @Override
    public MvpPresenter createPresenter() {
        return null;
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }
}
