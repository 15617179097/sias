package com.nice.web.controller;
import com.nice.web.service.UserInfoService;
import com.nice.web.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    private UserInfoService userInfoService;

    /**
     * @Description 获取用户信息
     * @param
     * @return com.nice.web.utils.DataResult
     **/
    @GetMapping("/findUserInfo")
    public DataResult findUser(){
        return userInfoService.findUserInfo();
    }

    @PostMapping("userinfo")
    public DataResult insertUserinfo(String studentId,String name){
        return userInfoService.insertUserinfo(studentId,name);
    }
}
