package com.zq.dagger2demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zq.dagger2demo.component.DaggerLoginComponent;
import com.zq.dagger2demo.module.UserManagerModule;

import javax.inject.Inject;

public class Main2Activity extends AppCompatActivity {

    @Inject
    UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DaggerLoginComponent.builder().userManagerModule(new UserManagerModule("kkkkkkkk"))
                .build()
                .inject(this);
        userManager.getUserInfo();

        Log.e("123123", "userManager333: " + userManager);
    }
}
