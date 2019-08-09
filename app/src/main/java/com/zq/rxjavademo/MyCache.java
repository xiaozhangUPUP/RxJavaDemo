package com.zq.rxjavademo;

import android.util.LruCache;

/**
 * Created by zhangqi on 2019/8/6
 */
public class MyCache {

    private static int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);// kB
    private static int cacheSize = maxMemory / 8;

    public static final String CORRECT_PHOTO_LIST = "correctPhotoList";
    public static final String DEDUCT_LIST = "deductsList";
    public static final String CAUSE_LIST = "causesList";

    public static LruCache<String, Object> mLruCache = new LruCache<String, Object>(cacheSize);


}
