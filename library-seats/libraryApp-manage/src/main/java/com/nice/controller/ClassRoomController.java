package com.nice.controller;

import com.nice.service.ClassRoomService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @Description 查询今天教室信息以及预约的座位数量
     * @param pagenum
     * @param pagesize
     * @return com.nice.utils.DataResult
     **/
    @GetMapping("/today")
    public DataResult findTodayClassRoom(@RequestParam(value = "pagenum",defaultValue = "1") Integer pagenum,
                                         @RequestParam(value = "pagesize",defaultValue = "10") Integer pagesize){
        return  classRoomService.findTodayClassRoom(pagenum,pagesize);
    }

    /**
     * @Description 查询今天教室信息以及预约的座位数量
     * @param pagenum
     * @param pagesize
     * @return com.nice.utils.DataResult
     **/

    @GetMapping("/tomorrow")
    public DataResult findTomorrowClassRoom(@RequestParam(value = "pagenum",defaultValue = "1") Integer pagenum,
                                            @RequestParam(value = "pagesize",defaultValue = "10") Integer pagesize){
        return  classRoomService.findTomorrowClassRoom(pagenum,pagesize);
    }

    /**
     * @Description 查询教室列表
     * @param
     * @return com.nice.utils.DataResult
     **/
    @GetMapping("/findClassRoom")
    public DataResult findClassRoom(){
        return  classRoomService.findClassRoom();
    }
}
