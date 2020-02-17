package com.nice.controller;

import com.nice.service.RedisService;
import com.nice.service.UserService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;


    @RequestMapping("index")
    public DataResult index(){

        return  DataResult.ok();
    }
    @RequestMapping("findUserByLoginStateUUid")
    public DataResult findUserByLoginStateUUid(String loginStateUUID){
        return  userService.findUserByLoginStateUUid(loginStateUUID);
    }
    @RequestMapping("saveUserByLoginStateUUid")
    public DataResult saveUserByLoginStateUUid(String loginStateUUID, String studentId){
        return  userService.saveUserByLoginStateUUid(loginStateUUID, studentId);
    }
    /*
    查询我的违约记录
     */
    @RequestMapping("/findUserRecordByUserId")
    public DataResult findUserRecordByUserId(String loginStateUUID){
        return userService.findUserRecordByUserId(loginStateUUID);
    }
    /*
    查询我的预约记录
     */
    @RequestMapping("/findMyAllSubscribe")
    public DataResult findMyAllSubscribe(String loginStateUUID) {
        return userService.findMyAllSubscribe(loginStateUUID);
    }
}
