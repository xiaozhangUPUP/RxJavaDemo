package com.zq.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zq.rxjavademo.rximageloader.RxImageLoader;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class RxImageLoaderActivity extends AppCompatActivity {

    private static final String TAG = RxImageLoaderActivity.class.getSimpleName();
    private Button btn;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_image_loader);

        //        RxImageLoader.with(this).load("").into(null);

        btn = findViewById(R.id.btn);
        img = findViewById(R.id.img111);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxImageLoader.with(RxImageLoaderActivity.this)
                        .load("https://operator.duolunxc.com/static/login/newLogin/logo.png")
                        .into(img);
            }
        });


    }
}
