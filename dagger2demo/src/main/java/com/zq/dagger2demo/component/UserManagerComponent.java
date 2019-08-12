package com.zq.dagger2demo.component;

import com.zq.dagger2demo.Main2Activity;
import com.zq.dagger2demo.anno.ActivityScope;
import com.zq.dagger2demo.MainActivity;
import com.zq.dagger2demo.module.UserManagerModule;

import dagger.Component;

/**
 * Created by zhangqi on 2019/8/12
 */
@ActivityScope
@Component(modules = UserManagerModule.class, dependencies = AppComponent.class)
public interface UserManagerComponent {
    void inject(MainActivity activity);
    void inject2(Main2Activity activity);




}
