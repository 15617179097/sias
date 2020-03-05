package com.nice.controller;


import com.nice.service.SeatsService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //查询以及预约的座位数据
    @GetMapping("seats/classroomId/{classroomId}")
    public DataResult findSubscribeSeats(@PathVariable("classroomId")Integer classroomId){
        return seatsService.findSubscribeSeats(classroomId);
    }
}
