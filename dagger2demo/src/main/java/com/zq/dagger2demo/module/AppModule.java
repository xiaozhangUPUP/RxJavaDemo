package com.zq.dagger2demo.module;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangqi on 2019/8/12
 */
@Module
public class AppModule {
    @Provides
    @Singleton
    public Gson provideGson() {
        return new Gson();
    }
}
