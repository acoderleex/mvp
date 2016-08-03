package com.example.tony.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.tony.mvp.base.BaseActivity;
import com.example.tony.mvp.utils.ActivityUtils;
import com.example.tony.mvp.views.login.ZYLoginFragment;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * Created by Tony on 7/7/16.
 */
public class ZYMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), ZYLoginFragment.newInstance("id"), R.id.contentFrame);
    }
}
