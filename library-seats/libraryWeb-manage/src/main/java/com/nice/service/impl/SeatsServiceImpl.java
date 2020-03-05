package com.nice.service.impl;

import com.nice.mapper.SeatsMapper;
import com.nice.mapper.SubscribeMapper;
import com.nice.pojo.Subscribe;
import com.nice.service.SeatsService;
import com.nice.utils.DataResult;
import com.nice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-04 22:28
 *
 * @author wmj
 * @version 1.0
 */
@Service
public class SeatsServiceImpl implements SeatsService {

    //座位mapper
    @Autowired
    private SeatsMapper seatsMapper;
    @Autowired
    private SubscribeMapper subscribeMapper;

    //查询根据classroomId已经预约的座位信息
    @Override
    public DataResult findSubscribeSeats(Integer classroomId) {

        //根据教室id获取对应的座位
        List<Map<String, Object>> seatsByClassRoomId = seatsMapper.findSeatsByClassRoomId(classroomId);

        //查询今天已经预约座位数量
        List<Subscribe> subscribeSeats = subscribeMapper.findSubscribeSeats(DateUtil.nowCreateTime(), DateUtil.nowEndTime(), null);
        for(Map<String,Object> map:seatsByClassRoomId){
            for (Subscribe subscribe:subscribeSeats){
                if(map.get("id")==subscribe.getSeatsId()){
                    map.put("sT",false);
                }else {
                    map.put("sT",false);
                }
            }
            if(subscribeSeats.size()==0){
                map.put("sT",false);
            }
        }
        Map<String,Object> maps=new HashMap<>();
        //获取已经预约的数量
        maps.put("seatsList",seatsByClassRoomId);
        if (subscribeSeats.size()==0) maps.put("suNum",0);
        else   maps.put("suNum",subscribeSeats.size());
        return DataResult.ok(maps);
    }
}
