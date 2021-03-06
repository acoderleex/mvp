package com.example.tony.mvp.views.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.tony.mvp.R;
import com.example.tony.mvp.ZYApplication;
import com.example.tony.mvp.base.BaseFragment;
import com.example.tony.mvp.models.ZYLoginResponseBean;
import com.example.tony.mvp.presenters.ZYLoginPresenter;

import butterknife.Bind;

/**
 * Created by Tony on 7/8/16.
 */
public class ZYLoginFragment extends BaseFragment<SwipeRefreshLayout, ZYLoginResponseBean, ZYLoginView, ZYLoginPresenter> implements ZYLoginView {

    private ZYLoginComponent component;

    private Context context;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData(false);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.countries_list;
    }

    @Override
    public void injectDependences() {
        component = DaggerZYLoginComponent.builder().applicationComponent(ZYApplication.getComponent()).build();
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public ZYLoginPresenter createPresenter() {
        return component.presenter();
    }

    @Override
    public void setData(ZYLoginResponseBean data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.doLogin(context, null);
    }


    public static ZYLoginFragment newInstance(String taskId) {
        Bundle arguments = new Bundle();
        arguments.putString("id", taskId);
        ZYLoginFragment fragment = new ZYLoginFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void showLoginSuccessful() {

    }
}
