package com.guohua.vo;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by 郭华 on 2017/8/3.
 */

public class Category extends DataSupport {
    private String name;
    private List<News> newses;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<News> getNewses() {
        return newses;
    }

    public void setNewses(List<News> newses) {
        this.newses = newses;
    }
}
