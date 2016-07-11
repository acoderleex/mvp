package com.example.tony.mvp.base.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

/**
 * Created by Tony on 7/11/16.
 */

@Module
public class AppModule {
    @Singleton
    @Provides
    public EventBus providesEventBus() {
        return EventBus.getDefault();
    }
}

