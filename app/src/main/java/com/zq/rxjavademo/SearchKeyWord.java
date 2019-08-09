package com.zq.rxjavademo;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class SearchKeyWord extends AppCompatActivity {

    private static final String TAG = SearchKeyWord.class.getSimpleName();
    private EditText editText;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_key_word);

        editText = findViewById(R.id.editText);

        RxTextView.textChanges(editText).skipInitialValue()
                .debounce(500, TimeUnit.MILLISECONDS) // 延时发送
                .filter(new Predicate<CharSequence>() { // 过滤空字符串
                    @Override
                    public boolean test(CharSequence charSequence) throws Exception {
                        return charSequence.toString().trim().length() > 0;
                    }
                })
                .switchMap(new Function<CharSequence, ObservableSource<List<String>>>() { // 只发射最近一次
                    @Override
                    public ObservableSource<List<String>> apply(CharSequence charSequence) throws Exception {
                        Log.e(TAG, "switchMap apply: " + charSequence.toString());

                        List<String> list = new ArrayList<>();
                        list.add("c");
                        list.add("java");
                        list.add("kotlin");
                        return Observable.just(list);
                    }
                })
                //                .flatMap(new Function<CharSequence, ObservableSource<List<String>>>() {
                //                    @Override
                //                    public ObservableSource<List<String>> apply(CharSequence charSequence) throws Exception {
                //                        Log.e(TAG, "apply: " + charSequence.toString());
                //
                //                        List<String> list = new ArrayList<>();
                //                        list.add("c");
                //                        list.add("java");
                //                        list.add("kotlin");
                //                        return Observable.just(list);
                //                    }
                //                })
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> strings) throws Exception {
                        Log.e(TAG, "accept: " + Arrays.toString(strings.toArray()));
                    }
                });
    }
}
