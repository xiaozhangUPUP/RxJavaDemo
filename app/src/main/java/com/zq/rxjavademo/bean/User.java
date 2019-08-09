package com.zq.rxjavademo.bean;

import com.google.gson.Gson;

/**
 * Created by zhangqi on 2019/8/7
 */
public class User {
    private int id;

    private String logo_url;

    private String username;

    private String mobi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobi() {
        return mobi;
    }

    public void setMobi(String mobi) {
        this.mobi = mobi;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

