package com.nice.web.pojo;

import java.util.Date;

/**
 * @ClassName UserFeedback  反馈
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/6
 * @Version V1.0
 **/
public class UserFeedback {
    private Integer id;

    private Integer userId;

    private String feedbackText;

    private Date createTime;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText == null ? null : feedbackText.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}