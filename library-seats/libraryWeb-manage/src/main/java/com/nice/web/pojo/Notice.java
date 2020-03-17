package com.nice.web.pojo;

/**
 * @author msl
 * @version 1.0
 * @date 2020/3/13 13:37
 */
//公告内容
public class Notice {
    private Integer id;
    private String title;
    private String content;
    private String time;//YYYY-MM-DD HH:MM:SS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

