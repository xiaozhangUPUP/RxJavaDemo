package com.zq.rxjavademo;

import com.zq.rxjavademo.bean.Request;
import com.zq.rxjavademo.bean.Root;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by zhangqi on 2019/8/6
 */
public interface Api {

    @POST("login")
    Call<Root> getUser(@Body Request request);


}
