package com.zq.retrofitdemo.bean;

import com.google.gson.Gson;

/**
 * Created by zhangqi on 2019/6/27
 */
public class GetDeductRsp {
    private String msg;

    private String code;

    private Data data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
