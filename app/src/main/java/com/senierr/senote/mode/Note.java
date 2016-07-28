package com.senierr.senote.mode;

/**
 * Created by zhouchunjie on 2016/7/28.
 */
public class Note {

    private int id;
    private String title;
    private String content_text;
    private String content_record;
    private String content_pic;
    private long createTime;
    private long updateTime;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent_text() {
        return content_text;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
    }

    public String getContent_record() {
        return content_record;
    }

    public void setContent_record(String content_record) {
        this.content_record = content_record;
    }

    public String getContent_pic() {
        return content_pic;
    }

    public void setContent_pic(String content_pic) {
        this.content_pic = content_pic;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
