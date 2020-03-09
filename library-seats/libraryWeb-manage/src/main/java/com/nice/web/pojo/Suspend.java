package com.nice.web.pojo;

/**
 * @ClassName Suspend  暂离
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/6
 * @Version V1.0
 **/
public class Suspend {
    private Integer id;
    private Integer subscribeId;
    private String suspendTime;
    private String endTime;
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(Integer subscribeId) {
        this.subscribeId = subscribeId;
    }

    public String getSuspendTime() {
        return suspendTime;
    }

    public void setSuspendTime(String suspendTime) {
        this.suspendTime = suspendTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
