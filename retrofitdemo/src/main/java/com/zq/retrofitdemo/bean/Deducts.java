package com.zq.retrofitdemo.bean;

/**
 * Created by zhangqi on 2019/6/27
 */
public class Deducts {
    private String code;

    private String name;

    private int value;

    public Deducts(String code, String name, int value) {
        this.code = code;
        this.name = name;
        this.value = value;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
