package com.example.tony.mvp.views.login;

import com.example.tony.mvp.base.dagger.AppModule;
import com.example.tony.mvp.base.dagger.ApplicationComponent;
import com.example.tony.mvp.presenters.ZYLoginPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Tony on 7/11/16.
 */
@Singleton
@Component(modules = AppModule.class, dependencies = ApplicationComponent.class)
public interface ZYLoginComponent {
    public ZYLoginPresenter presenter();
}
