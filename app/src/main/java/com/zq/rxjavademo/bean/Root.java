package com.zq.rxjavademo.bean;

/**
 * Created by zhangqi on 2019/8/7
 */
public class Root {
    private Data data;

    private int status;

    private String message;

    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return this.status;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
