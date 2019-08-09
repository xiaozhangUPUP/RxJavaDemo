package com.zq.rxjavademo;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zq.rxjavademo.bean.Request;
import com.zq.rxjavademo.bean.Root;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchedulerTestActivity extends AppCompatActivity {
    private static final String TAG = SchedulerTestActivity.class.getSimpleName();
    private Button btn;
    private TextView text;
    private ImageView img;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler_test);

        // init retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://112.124.22.238:8081/course_api/cniaoplay/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


        btn = findViewById(R.id.btn);
        text = findViewById(R.id.text);
        img = findViewById(R.id.img);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.create(new ObservableOnSubscribe<User>() {
                    @Override
                    public void subscribe(ObservableEmitter<User> e) throws Exception {
                        e.onNext(new User("1", "2", "3"));

                    }
                }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<User>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(User user) {
                                text.append(user.getHead_url() + "\n");

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });

        mapDemo(); // 转换

        getUser(); // flatmap
    }

    private void getUser() {
        Observable.just(new Request("15605195830", "daohaosima320219"))
                .flatMap(new Function<Request, ObservableSource<Root>>() {
                    @Override
                    public ObservableSource<Root> apply(Request request) throws Exception {
                        Root root = api.getUser(request).execute().body();
                        return Observable.just(root);
                    }
                }).flatMap(new Function<Root, ObservableSource<com.zq.rxjavademo.bean.User>>() {
            @Override
            public ObservableSource<com.zq.rxjavademo.bean.User> apply(Root root) throws Exception {
                return Observable.just(root.getData().getUser());
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<com.zq.rxjavademo.bean.User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(com.zq.rxjavademo.bean.User user) {
                        Log.e(TAG, "onNext: " + user);
                        text.setText(user.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    void mapDemo() {
        Observable.just(123)
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "rxjava: " + integer;
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(TAG, "accept: " + s);
                    }
                });
    }
}
