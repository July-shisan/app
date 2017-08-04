package com.guohua.vo;

import org.litepal.crud.DataSupport;

/**
 * Created by 郭华 on 2017/8/3.
 */

public class Introduction extends DataSupport {
    private String guid;
    private String content;
    private News news;

    public Introduction(String content) {
        this.content = content;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
