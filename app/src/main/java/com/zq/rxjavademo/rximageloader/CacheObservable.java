package com.zq.rxjavademo.rximageloader;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zhangqi on 2019/8/8
 */
public abstract class CacheObservable {

    public Observable<Image> getImage(final String url) {
        return Observable.create(new ObservableOnSubscribe<Image>() {
            @Override
            public void subscribe(ObservableEmitter<Image> e) throws Exception {

                Image imageFromCache = getImageFromCache(url);
                if (imageFromCache != null) {
                    e.onNext(imageFromCache);
                }
                e.onComplete();


            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public abstract Image getImageFromCache(String url);

    public abstract void putImageToCache(Image image);

}
