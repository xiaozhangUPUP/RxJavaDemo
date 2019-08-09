package com.zq.rxjavademo.rximageloader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zhangqi on 2019/8/8
 */
public class RxImageLoader {
    private static final String TAG = RxImageLoader.class.getSimpleName();
    private String url;
    private RequestCreator creator;

    public RxImageLoader load(String url) {
        this.url = url;
        return this;
    }

    @SuppressLint("CheckResult")
    public void into(final ImageView imageView) {

        Observable.concat(creator.getImageFromMemory(url), creator.getImageFromDisk(url)
                , creator.getImageFromNetwork(url))
                .filter(new Predicate<Image>() {
                    @Override
                    public boolean test(Image image) throws Exception {
                        return image != null;
                    }
                }).firstElement()
                .toObservable()
                .subscribe(new Observer<Image>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(Image image) {
                        Log.e(TAG, "onNext: " + image);
                        imageView.setImageBitmap(image.getBitmap());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: ");
                    }
                });

    }

    private RxImageLoader(Builder builder) {
        creator = new RequestCreator(builder.context);
    }

    private static RxImageLoader singleton;

    public static RxImageLoader with(Context context) {
        if (singleton == null) {
            synchronized (RxImageLoader.class) {
                if (singleton == null) {
                    singleton = new Builder(context).build();
                }
            }
        }
        return singleton;
    }


    private static class Builder {
        private Context context;

        public Builder(Context context) {
            this.context = context;
        }

        public RxImageLoader build() {
            return new RxImageLoader(this);
        }
    }
}
