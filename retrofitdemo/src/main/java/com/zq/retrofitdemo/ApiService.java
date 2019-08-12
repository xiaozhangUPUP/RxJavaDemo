package com.zq.retrofitdemo;

import com.zq.retrofitdemo.bean.GetDeductReq;
import com.zq.retrofitdemo.bean.GetDeductRsp;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by zhangqi on 2019/8/12
 */
public interface ApiService {

    // post方式
    @POST("robot/getDeduct.do")
    Call<GetDeductRsp> getDeduct(@Body GetDeductReq req);

    // post 表单方式
    //    @POST
    //    @FormUrlEncoded
    //    Call<User> getUserInfoWithForm(@Field("name") String name, @Field("password") String pwd);


    // get方式
    //    @GET("user/info")
    //    Call<User> getUserInfo(@Query("id") int id);                            //query

    //    @GET("user/info")
    //    Call<User> getUserInfoWithPath(@Path("id") int id);                     // path

    //    @GET("user/info")
    //    Call<User> getUserInfoWithQueryMap(@QueryMap Map<String, String> params); // querymap

    // 更改头信息  header
    //    @Headers({"User-Agent:hahha","My_Header:myHead"})
    //    Call<GetDeductRsp> getsss();
}
