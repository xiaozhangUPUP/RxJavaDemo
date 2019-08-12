package com.zq.dagger2demo.module;

import com.zq.dagger2demo.anno.ActivityScope;
import com.zq.dagger2demo.UserManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangqi on 2019/8/12
 */
@Module
public class UserManagerModule {

    private String string;

    public UserManagerModule(String string) {
        this.string = string;
    }

    @Provides
    @ActivityScope
    public UserManager provideUserManager() {
        return new UserManager(string);
    }
}
