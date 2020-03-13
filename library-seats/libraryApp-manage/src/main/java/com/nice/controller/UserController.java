package com.nice.controller;

import com.nice.service.ModularService;
import com.nice.service.UserService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;

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
    @GetMapping("userInfo/{loginStateUUID}")
    public DataResult findUserByLoginStateUUid(HttpServletRequest request, @PathVariable("loginStateUUID") String loginStateUUID){
        return  userService.findUserByLoginStateUUid(request);
    }

    /*
        添加学号
     */
    @PostMapping("userInfo/{loginStateUUID}")
    public DataResult saveUserByLoginStateUUid(HttpServletRequest request, String studentId){
        return  userService.saveUserByLoginStateUUid(request, studentId);
    }

    /*
    查询我的违约记录
     */
    @GetMapping("/findUserRecordByUserId")
    public DataResult findUserRecordByUserId(HttpServletRequest request){
        return userService.findUserRecordByUserId(request);
    }

    /*
    查询我的预约记录
     */
    @GetMapping("/findMyAllSubscribe")
    public DataResult findMyAllSubscribe(HttpServletRequest request) {
        return userService.findMyAllSubscribe(request);
    }

    /*用户列表 */
    @RequestMapping("/users")
    public DataResult findAllUsers(){

        return userService.findAllUsers();
    }

    @PostMapping("userInfo/del")
    public DataResult deleteUserInfo(HttpServletRequest request){
        return userService.deleteUserInfo(request);
    }
}
