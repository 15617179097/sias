package com.nice.controller;

import com.nice.pojo.Subscribe;
import com.nice.service.SubscribeService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
/**
 * Company: 预约  <br>
 * Description:  <br>
 * Date: 2020-01-12 23:01
 *
 * @author wmj
 * @version 1.0
 */

@RestController
@RequestMapping("/subscribe")
public class SubscribeController {
    @Autowired
    private SubscribeService subscribeService;


    /**
     * @Description  用户预约
     * @param classroomId
     * @param seatsId
     * @param loginStateUUID
     * @param createTime
     * @param endTime
     * @return com.nice.utils.DataResult
     **/
    @PostMapping("/{classroomId}/{seatsId}")
    public DataResult saveSubscribe(@PathVariable("classroomId") Integer classroomId,@PathVariable("seatsId") Integer seatsId, String loginStateUUID, String createTime, String endTime) throws ParseException {

        boolean saveSubscribe = subscribeService.saveSubscribe(loginStateUUID,createTime,endTime,seatsId,classroomId);
        return DataResult.ok(saveSubscribe);
    }


    /**
     * @Description 校验用户是否已经预约
     * @param loginStateUUID
     * @return com.nice.utils.DataResult
     **/
    @GetMapping("/check")
    public DataResult checkSubscribe(String loginStateUUID){
        boolean checkSubscribe = subscribeService.checkSubscribe(loginStateUUID);
        return DataResult.ok(checkSubscribe);
    }

    /**
     * @Description 查询我的预约
     * @param loginStateUUID
     * @return com.nice.utils.DataResult
     **/
    @GetMapping("/my")
    public DataResult findMySubscribe(String loginStateUUID){
         return subscribeService.findMySubscribe(loginStateUUID);
    }

    /**
     * @Description 取消预约
     * @param subscribeId
     * @param loginStateUUID
     * @return com.nice.utils.DataResult
     **/
    @DeleteMapping("/{subscribeId}")
    public DataResult delSubscribe(@PathVariable("subscribeId") Integer subscribeId,String loginStateUUID){
        return  subscribeService.delSubscribe(loginStateUUID,subscribeId);
    }

}
