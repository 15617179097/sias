package com.nice.service.impl;

import com.nice.mapper.SeatsMapper;
import com.nice.mapper.SubscribeMapper;
import com.nice.pojo.Seats;
import com.nice.pojo.Subscribe;
import com.nice.service.SeatsService;
import com.nice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-13 15:14
 *
 * @author wmj
 * @version 1.0
 */
@Service
public class SeatsServiceImpl implements SeatsService {
    @Autowired
    private SeatsMapper seatsMapper;
    @Autowired
    private SubscribeMapper subscribeMapper;
        /*
        查询 座位信息
         */
    @Override
    public List<Seats> findSeatsByClassRoomId(int classroomId) {
        Seats seats=new Seats();
        seats.setClassroomId(classroomId);
        return seatsMapper.findSeats(seats);
    }


    /**
     * @Description 查询 座位信息 是否 被预约
     * @param classroomId
     * @param createTime
     * @param timeState
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    @Override
    public List<Map<String,Object>> findSeatsByClassRoomIdAndCreateTime(int classroomId,String createTime,Integer timeState) {
        Seats seats=new Seats();
        seats.setClassroomId(classroomId);
        List<Map<String,Object>> seats1 = seatsMapper.findSeatsMap(seats);
        List<Subscribe> allSubscribe =null;
        //timeState 0是今天的预约 1 明天预约
        if (timeState==0)
            allSubscribe = subscribeMapper.findSubscribe(DateUtil.nowCreateTime(),DateUtil.nowEndTime(),createTime,null);
        else
            allSubscribe = subscribeMapper.findSubscribe(DateUtil.TomorrowCreateTime(),DateUtil.TomorrowEndTime(),createTime,null);
        int i=0;
        for(Subscribe su:allSubscribe){
        for (Map<String,Object> s:seats1){
                if(s.get("id").equals(su.getSeatsId())){
                    s.put("seatsV",true);
                    break;
                }
            }
        }
        return seats1;
    }



}
