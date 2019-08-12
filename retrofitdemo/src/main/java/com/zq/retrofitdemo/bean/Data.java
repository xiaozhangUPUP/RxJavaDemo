package com.zq.retrofitdemo.bean;

import java.util.List;

/**
 * Created by zhangqi on 2019/6/27
 */
public class Data {
    private List<Deducts> deducts;

    private List<Causes> causes;

    public void setDeducts(List<Deducts> deducts) {
        this.deducts = deducts;
    }

    public List<Deducts> getDeducts() {
        return this.deducts;
    }

    public void setCauses(List<Causes> causes) {
        this.causes = causes;
    }

    public List<Causes> getCauses() {
        return this.causes;
    }

}
