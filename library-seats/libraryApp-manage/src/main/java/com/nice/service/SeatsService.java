package com.nice.service;

import com.nice.pojo.Seats;

import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-13 15:13
 *
 * @author wmj
 * @version 1.0
 */
public interface SeatsService {
    public List<Seats> findSeatsByClassRoomId(int classroomId);
    //查询未被预约的座位
    public List<Map<String,Object>> findSeatsByClassRoomIdAndCreateTime(int classroomId, String createTime, Integer timeState);
}
