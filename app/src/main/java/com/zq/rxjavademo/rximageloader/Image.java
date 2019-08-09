package com.zq.rxjavademo.rximageloader;

import android.graphics.Bitmap;

/**
 * Created by zhangqi on 2019/8/8
 */
public class Image {
    private String url;
    private Bitmap bitmap;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Image(String url, Bitmap bitmap) {
        this.url = url;
        this.bitmap = bitmap;
    }

    @Override
    public String toString() {
        return "Image{" +
                "url='" + url + '\'' +
                ", bitmap=" + bitmap +
                '}';
    }
}
