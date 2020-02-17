package com.nice.pojo;
/**
 * @ClassName Seats  座位
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/6
 * @Version V1.0
 **/
public class Seats {
    private Integer id;

    private Integer classroomId;

    private Integer seatMunber;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public Integer getSeatMunber() {
        return seatMunber;
    }

    public void setSeatMunber(Integer seatMunber) {
        this.seatMunber = seatMunber;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}