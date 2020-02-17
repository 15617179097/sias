package com.nice.pojo;

import java.util.Date;

/**
 * @ClassName UserRecord  用户记录
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/6
 * @Version V1.0
 **/
public class UserRecord {
    private Integer id;

    private Integer userId;

    private Integer signInId;

    private String illegalText;

    private Date illegalTime;

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

    public Integer getSignInId() {
        return signInId;
    }

    public void setSignInId(Integer signInId) {
        this.signInId = signInId;
    }

    public String getIllegalText() {
        return illegalText;
    }

    public void setIllegalText(String illegalText) {
        this.illegalText = illegalText == null ? null : illegalText.trim();
    }

    public Date getIllegalTime() {
        return illegalTime;
    }

    public void setIllegalTime(Date illegalTime) {
        this.illegalTime = illegalTime;
    }
}