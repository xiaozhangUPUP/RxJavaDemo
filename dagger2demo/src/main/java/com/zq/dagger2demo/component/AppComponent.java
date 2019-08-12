package com.zq.dagger2demo.component;

import com.google.gson.Gson;
import com.zq.dagger2demo.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhangqi on 2019/8/12
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    public Gson getGson();
}
