package com.example.tony.mvp.views;

import com.example.tony.mvp.base.BaseFragment;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * Created by Tony on 7/11/16.
 */
public class OtherFragment extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return 0;
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public MvpPresenter createPresenter() {
        return null;
    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }

    @Override
    public void injectDependences() {

    }
}
