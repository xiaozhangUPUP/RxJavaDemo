package com.zq.dagger2demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.zq.dagger2demo.component.DaggerUserManagerComponent;
import com.zq.dagger2demo.module.UserManagerModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    UserManager userManager;

    @Inject
    UserManager userManager2;


    @Inject
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerUserManagerComponent.builder()
                .appComponent(((MyApplication) getApplication()).getAppComponent())
                .userManagerModule(new UserManagerModule("lalallal"))
                .build()
                .inject(this);

        userManager.getUserInfo();

        Log.e("123123", "userManager: " + userManager);
        Log.e("123123", "userManager2: " + userManager2);
    }

    public void clickHello(View view) {
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
    }
}
