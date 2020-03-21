package com.nice.web.controller;


import com.nice.web.pojo.Seats;
import com.nice.web.service.SeatsService;
import com.nice.web.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-12 23:01
 *
 * @author wmj
 * @version 1.0
 */
@RestController
public class SeatsController {

    @Autowired
    private SeatsService seatsService;

    /**
     * @Description 查询以及预约的座位数据
     * @param createTime
     * @param classroomId
     * @param state 代表今天或者明天
     * @return com.nice.web.utils.DataResult
     **/
    @GetMapping("seats/classroomId/{classroomId}/state/{state}")
    public DataResult findSubscribeSeats(String createTime, @PathVariable("classroomId")Integer classroomId, @PathVariable("state")String state){
        return seatsService.findSubscribeSeats(classroomId,createTime,state);
    }
    /**
     * @Description 修改座位状态
     * @param id
     * @param state
     * @return com.nice.web.utils.DataResult
     **/
    @PutMapping("seats/{id}/{state}")
    public DataResult updateState(@PathVariable("id")Integer id,@PathVariable("state")Integer state){
        return seatsService.updateState(id, state);
    }
    /**
     * @Description  添加座位
     * @param seats
     * @return com.nice.web.utils.DataResult
     **/
    @PostMapping("insertSeats")
    public DataResult insertSeats(Seats seats){
        return DataResult.ok(seatsService.insertSeats(seats));
    }

    /**
     * @Description 删除座位
     * @param id
     * @return com.nice.web.utils.DataResult
     **/
    @PostMapping("deleteSeats/{id}")
    public DataResult deleteSeats(@PathVariable("id")Integer id){
        return DataResult.ok(seatsService.deleteSeats(id));
    }
}
