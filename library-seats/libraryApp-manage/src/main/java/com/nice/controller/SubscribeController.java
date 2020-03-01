package com.nice.controller;

import com.nice.pojo.Subscribe;
import com.nice.service.SubscribeService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    /*
        查询所以预约
     */
    @RequestMapping("/findAllSubscribe")
    public DataResult findAllSubscribe(){
        List<Subscribe> allSubscribe = subscribeService.findAllSubscribe();
        return DataResult.ok(allSubscribe);
    }

    /*
    进行预约
     */
    @RequestMapping("/saveSubscribe")
    public DataResult saveSubscribe(String loginStateUUID, String createTime, String endTime, Integer seatsId, Integer classroomId) throws ParseException {

        boolean saveSubscribe = subscribeService.saveSubscribe(loginStateUUID,endTime,createTime,seatsId,classroomId);
        return DataResult.ok(saveSubscribe);
    }

    /*
     校验是否已经预约
     */
    @RequestMapping("/checkTomorrowSubscribe")
    public DataResult checkSubscribe(String loginStateUUID, int classRoomId){
        boolean checkSubscribe = subscribeService.checkSubscribe(loginStateUUID);
        return DataResult.ok(checkSubscribe);
    }

    /*
     查询我的预约 在主页
    */
    @RequestMapping("/findMySubscribe")
    public DataResult findMySubscribe(String loginStateUUID){

         return subscribeService.findMySubscribe(loginStateUUID);
    }

    /*
        取消预约
     */
    @RequestMapping(value = "/delSubscribe",method = RequestMethod.POST)
    public DataResult delSubscribe(String loginStateUUID, Integer subscribeId){
        return  subscribeService.delSubscribe(loginStateUUID,subscribeId);
    }

}
