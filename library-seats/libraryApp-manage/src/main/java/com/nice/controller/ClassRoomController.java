package com.nice.controller;

import com.nice.service.ClassRoomService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Company: 教室 <br>
 * Description:  <br>
 * Date: 2020-01-12 23:01
 *
 * @author wmj
 * @version 1.0
 */
@RestController
@RequestMapping("/classRoom")
public class ClassRoomController {
    @Autowired
    private ClassRoomService classRoomService;

    //查询今天教室信息以及预约的座位数量
    @GetMapping("/today")
    public DataResult findTodayClassRoom(){
        return  classRoomService.findTodayClassRoom();
    }

    //查询今天教室信息以及预约的座位数量
    @GetMapping("/tomorrow")
    public DataResult findTomorrowClassRoom(){
        return  classRoomService.findTomorrowClassRoom();
    }

    /**
     * @Description 查询教室列表
     * @param
     * @return com.nice.utils.DataResult
     **/
    @GetMapping("/findClassRoom")
    public DataResult findClassRoom(){
        return  DataResult.ok(classRoomService.findClassRoom());
    }
}
