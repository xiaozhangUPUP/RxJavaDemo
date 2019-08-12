package com.zq.dagger2demo.component;

import com.zq.dagger2demo.Main2Activity;
import com.zq.dagger2demo.anno.ActivityScope;
import com.zq.dagger2demo.module.UserManagerModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhangqi on 2019/8/12
 */
@ActivityScope
@Component(modules = UserManagerModule.class)
public interface LoginComponent {
    void inject(Main2Activity activity);
}
