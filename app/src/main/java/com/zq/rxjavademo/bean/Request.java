package com.zq.rxjavademo.bean;

/**
 * Created by zhangqi on 2019/8/7
 */
public class Request {
    private String email;
    private String passWord;

    public Request(String email, String passWord) {
        this.email = email;
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
