package com.guohua.vo;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by 郭华 on 2017/8/3.
 */

public class News extends DataSupport {
    private String Title;
    private String content;
    private int commentcount;
    private List<Category> categories;
    private List<Comment> comments;

    public News() {}

    public News(String title, String content, int commentcount) {
        Title = title;
        this.content = content;
        this.commentcount = commentcount;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(int commentcount) {
        this.commentcount = commentcount;
    }
}
