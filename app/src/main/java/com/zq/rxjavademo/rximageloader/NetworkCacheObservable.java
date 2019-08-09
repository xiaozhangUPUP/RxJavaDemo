package com.zq.rxjavademo.rximageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.RelativeDateTimeFormatter;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by zhangqi on 2019/8/8
 */
public class NetworkCacheObservable extends CacheObservable {
    @Override
    public Image getImageFromCache(String url) {
        Bitmap bitmap = downloadImage(url);

        if (bitmap != null) {
            return new Image(url, bitmap);
        } else {
        }

        return null;
    }

    @Override
    public void putImageToCache(Image image) {

    }

    private Bitmap downloadImage(String url) {


        Bitmap bitmap = null;
        InputStream inputStream = null;
        try {

            final URLConnection con = new URL(url).openConnection();
            inputStream = con.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return bitmap;

    }
}
