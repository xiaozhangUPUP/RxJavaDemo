package com.zq.dagger2demo;

import android.app.Application;

import com.zq.dagger2demo.component.AppComponent;
import com.zq.dagger2demo.component.DaggerAppComponent;

/**
 * Created by zhangqi on 2019/8/12
 */
public class MyApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
