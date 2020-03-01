package com.nice.controller;

import com.nice.service.SeatsService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Company: 座位  <br>
 * Description:  <br>
 * Date: 2020-01-12 23:01
 *
 * @author wmj
 * @version 1.0
 */
@RestController
@RequestMapping("seats")
public class SeatsController {
    @Autowired
    private SeatsService seatsService;

    /*
        根据教室查询座位
     */
    @RequestMapping("findSeatsByClassRoomId/{ClassRoomId}")
    public DataResult findSeatsByClassRoomId(@PathVariable int ClassRoomId){

        return  DataResult.ok(seatsService.findSeatsByClassRoomId(ClassRoomId));
    }
    /*
        根据开始时间 查询座位信息
     */
    @RequestMapping("findSeatsByClassRoomIdAndCreateTime")
    public DataResult findSeatsByClassRoomIdAndCreateTime(Integer classRoomId, String createTime, Integer timeState){

        return  DataResult.ok(seatsService.findSeatsByClassRoomIdAndCreateTime(classRoomId,createTime,timeState));
    }
}
