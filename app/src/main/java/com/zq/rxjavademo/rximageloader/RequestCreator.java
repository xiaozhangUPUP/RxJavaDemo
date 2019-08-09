package com.zq.rxjavademo.rximageloader;

import android.content.Context;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * Created by zhangqi on 2019/8/8
 */
public class RequestCreator {

    private static final String TAG = RequestCreator.class.getSimpleName();
    private MemoryCacheObservable memoryCacheObservable;
    private DiskCacheObservable diskCacheObservable;
    private NetworkCacheObservable networkCacheObservable;

    public RequestCreator(Context context) {
        memoryCacheObservable = new MemoryCacheObservable();
        diskCacheObservable = new DiskCacheObservable(context);
        networkCacheObservable = new NetworkCacheObservable();
    }

    public Observable<Image> getImageFromMemory(String url) {

        return memoryCacheObservable.getImage(url)
                .filter(new Predicate<Image>() {
                    @Override
                    public boolean test(Image image) throws Exception {
                        return image != null;
                    }
                }).doOnNext(new Consumer<Image>() {
                    @Override
                    public void accept(Image image) throws Exception {
                        Log.e(TAG, "get data from memory");
                    }
                });
    }

    public Observable<Image> getImageFromDisk(String url) {

        return diskCacheObservable.getImage(url)
                .filter(new Predicate<Image>() {
                    @Override
                    public boolean test(Image image) throws Exception {
                        return image != null;
                    }
                }).doOnNext(new Consumer<Image>() {
                    @Override
                    public void accept(Image image) throws Exception {
                        Log.e(TAG, "get data from disk");
                        memoryCacheObservable.putImageToCache(image);
                    }
                });
    }

    public Observable<Image> getImageFromNetwork(String url) {

        return networkCacheObservable.getImage(url)
                .filter(new Predicate<Image>() {
                    @Override
                    public boolean test(Image image) throws Exception {
                        return image != null;
                    }
                }).doOnNext(new Consumer<Image>() {
                    @Override
                    public void accept(Image image) throws Exception {
                        Log.e(TAG, "get data from network");
                        if (image != null) {
                            diskCacheObservable.putImageToCache(image);
                            memoryCacheObservable.putImageToCache(image);
                        }
                    }
                });
    }
}
