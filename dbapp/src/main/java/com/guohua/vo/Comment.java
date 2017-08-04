package com.guohua.vo;

import org.litepal.crud.DataSupport;

import java.util.Date;

/**
 * Created by 郭华 on 2017/8/3.
 */

public class Comment extends DataSupport {
    private String content;
    private Date commentDate;
    private News news;

    public Comment(String content) {
        this.content = content;
    }

    public Comment(String content, Date commentDate) {
        this.content = content;
        this.commentDate = commentDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
