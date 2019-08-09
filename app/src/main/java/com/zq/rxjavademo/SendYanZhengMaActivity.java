package com.zq.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class SendYanZhengMaActivity extends AppCompatActivity {
    private static final String TAG = SendYanZhengMaActivity.class.getSimpleName();
    private EditText input;
    private Button send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_yan_zheng_ma);

        input = findViewById(R.id.input);
        send = findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int count = 10;
                Observable.interval(0, 1, TimeUnit.SECONDS)
                        .take(count + 1)
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(new Function<Long, Long>() {
                            @Override
                            public Long apply(Long aLong) throws Exception {
                                return count - aLong;
                            }
                        })
                        .subscribe(new Observer<Long>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.e(TAG, "onSubscribe: ");
                                send.setEnabled(false);
                            }

                            @Override
                            public void onNext(Long aLong) {
                                Log.e(TAG, "onNext: " + aLong);
                                send.setText("剩余 " + aLong + " s");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "onError: " + e.getMessage());
                            }

                            @Override
                            public void onComplete() {
                                Log.e(TAG, "onComplete: ");
                                send.setEnabled(true);
                                send.setText("send");
                            }
                        });
            }
        });
    }
}
