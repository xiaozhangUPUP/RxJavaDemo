package com.zq.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

public class BtnReClickActivity extends AppCompatActivity {

    private static final String TAG = BtnReClickActivity.class.getSimpleName();
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn_re_click);

        btn = findViewById(R.id.btn);

        RxView.clicks(btn).throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Log.e(TAG, "------accept: ");
                    }
                });
    }
}
