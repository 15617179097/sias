package com.nice.controller;

import com.nice.service.ModularService;
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
    private ModularService modularService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public DataResult index(){
        return  modularService.findModular();
    }

    /*
        根据登陆态获取用户信息
     */
    @RequestMapping("findUserByLoginStateUUid")
    public DataResult findUserByLoginStateUUid(String loginStateUUID){
        return  userService.findUserByLoginStateUUid(loginStateUUID);
    }

    /*
        添加学号
     */
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

    /*用户列表 */
    @RequestMapping("/users")
    public DataResult findAllUsers(){

        return userService.findAllUsers();
    }
}
