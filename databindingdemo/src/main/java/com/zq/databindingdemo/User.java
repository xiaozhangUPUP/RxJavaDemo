package com.zq.databindingdemo;

import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

/**
 * Created by zhangqi on 2019/8/13
 */
public class User {


    //    public String name;
    //
    //    public User(String name) {
    //        this.name = name;
    //    }


    public ObservableField<String> name = new ObservableField<>();

    public void onClickName(View view) {
        Log.e("User", "------------------------onClickName----------------------- ");
    }
}
