package com.zq.rxjavademo.bean;

/**
 * Created by zhangqi on 2019/8/7
 */
public class Data {
    private String token;

    private User user;

    public void setToken(String token){
        this.token = token;
    }
    public String getToken(){
        return this.token;
    }
    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return this.user;
    }
}
