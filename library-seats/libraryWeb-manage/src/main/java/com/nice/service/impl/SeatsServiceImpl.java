package com.nice.service.impl;

import com.nice.mapper.ClassRoomMapper;
import com.nice.mapper.SeatsMapper;
import com.nice.mapper.SubscribeMapper;
import com.nice.pojo.Classroom;
import com.nice.pojo.Seats;
import com.nice.pojo.Subscribe;
import com.nice.service.SeatsService;
import com.nice.utils.DataResult;
import com.nice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

   @Autowired
    private SeatsMapper seatMapper;
    @Autowired
    private SubscribeMapper subscribeMapper;
    @Autowired
    private ClassRoomMapper classRoomMapper;

    //查询根据classroomId已经预约的座位信息
    @Override
    public DataResult findSubscribeSeats(Integer classroomId,String createTime,String state) {

        //根据教室id获取对应的座位
        List<Map<String, Object>> seatsByClassRoomId = seatMapper.findSeatsByClassRoomId(classroomId);

        //查询今天已经预约座位数量
        List<Subscribe> subscribeSeats = null;
        //判断是查询今天还是明天
        if(state.equals("Today"))
            subscribeSeats = subscribeMapper.findSubscribeSeats(DateUtil.nowCreateTime(), DateUtil.nowEndTime(),classroomId, createTime);
        else
            subscribeSeats = subscribeMapper.findSubscribeSeats(DateUtil.TomorrowCreateTime(), DateUtil.TomorrowEndTime(),classroomId, createTime);

        for(Map<String,Object> map:seatsByClassRoomId){
            for (Subscribe subscribe:subscribeSeats){
                if(map.get("id").equals(subscribe.getSeatsId())){
                    map.put("sT",false);
                }else {
                    map.put("sT",true);
                }
            }
            if(subscribeSeats.size()==0){
                map.put("sT",true);
            }
        }
        //查询教室x y
        List<Classroom> classRoomById = classRoomMapper.findClassRoomById(classroomId);
        Classroom roomById = classRoomById.get(0);
        int x = roomById.getX();
        List<Object> lis=new ArrayList<>();
        List<Map<String,Object>> li=new ArrayList<>();
        for (int i=0;i<=seatsByClassRoomId.size()-1;i++){

            if((i+1)%x!=0){
                li.add(seatsByClassRoomId.get(i));

            }else {
                li.add(seatsByClassRoomId.get(i));
                lis.add(li);
                li=new ArrayList<>();

            }
        }
        Map<String,Object> maps=new HashMap<>();
        //获取已经预约的数量
        maps.put("seatsList",lis);
        if (subscribeSeats.size()==0) maps.put("suNum",0);
        else   maps.put("suNum",subscribeSeats.size());
        return DataResult.ok(maps);
    }

    /**
     * 增加座位
     * @param seats
     * @return
     */
    @Override
    public DataResult insertSeats(Seats seats) {
        try {
            seatMapper.insertSeats(seats);
        }catch (Exception e){
            return DataResult.fail(500, "添加失败！！", e);
        }
        return DataResult.ok(seats);
    }

    /**
     * 删除座位
     * @param id
     * @return
     */
    @Override
    public DataResult deleteSeats(Integer id) {
        try {
            seatMapper.deleteSeates(id);
        }catch (Exception e){
            return DataResult.fail(500, "删除失败！！", e);
        }
        return DataResult.ok(id);
    }

}
