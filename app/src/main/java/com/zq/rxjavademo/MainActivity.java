package com.zq.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        final Observable observable = getObservable();

        final Observer observer = getObserver();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observable.subscribe(observer);


                observable.subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {

                    }
                });



            }

        });


    }


    public Observable getObservable() {

        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "google";
            }
        });

        //        return Observable.just("java", "c", "php", "kotlin");

        //        return Observable.create(new ObservableOnSubscribe<String>() {
        //            @Override
        //            public void subscribe(ObservableEmitter<String> e) throws Exception {
        //                e.onNext("hello  rxjava!!");
        //                e.onNext("amazing~~");
        //                e.onComplete();
        //            }
        //        });
    }


    public Observer getObserver() {
        return new Observer<String>() {
            Disposable dd;

            @Override
            public void onSubscribe(Disposable d) {
                dd = d;
                Log.e(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: ");
            }
        };

    }
}
