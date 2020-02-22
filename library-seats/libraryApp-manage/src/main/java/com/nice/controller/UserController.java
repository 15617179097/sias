package com.nice.controller;

import com.nice.service.RedisService;
import com.nice.service.UserService;
import com.nice.utils.DataResult;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-12 23:01
 *
 * @author wmj
 * @version 1.0
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public DataResult index(){
        return  DataResult.ok();
    }
    @RequestMapping("findUserByLoginStateUUid")
    public DataResult findUserByLoginStateUUid(String loginStateUUID){
        return  userService.findUserByLoginStateUUid(loginStateUUID);
    }
    @GetMapping("saveUserByLoginStateUUid")
    public DataResult saveUserByLoginStateUUid(String loginStateUUID, String studentId){
        return  userService.saveUserByLoginStateUUid(loginStateUUID, studentId);
    }
    /*
    查询我的违约记录
     */
    @GetMapping("/findUserRecordByUserId")
    public DataResult findUserRecordByUserId(String loginStateUUID){
        return userService.findUserRecordByUserId(loginStateUUID);
    }
    /*
    查询我的预约记录
     */
    @GetMapping("/findMyAllSubscribe")
    public DataResult findMyAllSubscribe(String loginStateUUID) {
        return userService.findMyAllSubscribe(loginStateUUID);
    }
}
