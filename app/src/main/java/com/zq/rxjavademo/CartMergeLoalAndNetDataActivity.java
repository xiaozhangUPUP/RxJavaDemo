package com.zq.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class CartMergeLoalAndNetDataActivity extends AppCompatActivity {
    private Button btn;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_merge_loal_and_net_data);

        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.merge(getDataFromLocal(), getDataFromNet()) // 合并多个Observable 顺序可能交错  concat 操作符可以保证有序
                        .subscribe(new Consumer<List<String>>() {
                            @Override
                            public void accept(List<String> strings) throws Exception {
                                for (String s : strings) {
                                    textView.append(s);
                                }

                            }
                        });
            }
        });
    }

    Observable<List<String>> getDataFromLocal() {
        List<String> list = new ArrayList<>();
        list.add("c");
        list.add("java");
        list.add("php");
        return Observable.just(list);
    }

    Observable<List<String>> getDataFromNet() {
        List<String> list = new ArrayList<>();
        list.add("时代杂志");
        list.add("国家地理");
        list.add("致富经");
        return Observable.just(list);
    }
}
