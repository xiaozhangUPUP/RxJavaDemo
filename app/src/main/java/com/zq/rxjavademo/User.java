package com.zq.rxjavademo;

import com.google.gson.Gson;

/**
 * Created by zhangqi on 2019/8/6
 */
class User {
    private String head_url;
    private String id;
    private String username;

    @Override
    public String toString() {

        return new Gson().toJson(this);
    }

    public User() {
    }

    public User(String head_url, String id, String username) {
        this.head_url = head_url;
        this.id = id;
        this.username = username;
    }

    public String getHead_url() {
        return head_url;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
