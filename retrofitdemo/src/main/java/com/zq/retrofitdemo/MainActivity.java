package com.zq.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.zq.retrofitdemo.bean.GetDeductReq;
import com.zq.retrofitdemo.bean.GetDeductRsp;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ApiService apiService;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://developapprest.duolunxc.com/mobileRest/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

    }

    public void onClickH(View view) {
        Call<GetDeductRsp> call = apiService.getDeduct(new GetDeductReq("3020", "blykri2g", "1370899"));
        call.enqueue(new Callback<GetDeductRsp>() {
            @Override
            public void onResponse(Call<GetDeductRsp> call, Response<GetDeductRsp> response) {
                Log.e(TAG, "onResponse: " + response.body().toString());
            }

            @Override
            public void onFailure(Call<GetDeductRsp> call, Throwable t) {

            }
        });


        apiService.getDeduct2(new GetDeductReq("3020", "blykri2g", "1370899"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetDeductRsp>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetDeductRsp value) {
                        textView.append("\n");
                        textView.setText(value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
