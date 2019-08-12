package com.zq.dagger2demo;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by zhangqi on 2019/8/12
 */
public class UserManager {

    private static final String TAG = UserManager.class.getSimpleName();
    private String string;

    public UserManager(String string) {
        this.string = string;
    }

    public void getUserInfo() {
        Log.e(TAG, "getUserInfo: " + string);
    }
}
