package com.nice.controller;
import com.nice.service.CheckLoginService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class WxLoginController {
    @Autowired
    private CheckLoginService checkLoginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public DataResult login(String studentId,String password, HttpServletRequest request){
        return checkLoginService.login(studentId,password,request);
    }
    /*
    wx登陆
     */
    @RequestMapping("/checkLogin")
    public DataResult checkLogin(String code, HttpServletRequest request){
        String token = checkLoginService.checkLogin(code, request);
        return DataResult.ok(token);
    }
    /*
  wx注册
   */
    @RequestMapping("/saveUserInfo")
    public DataResult saveUserInfo(String loginStateUUID,String encryptedData ,String iv){
        return  checkLoginService.saveUserInfo(loginStateUUID,encryptedData,iv);
    }
}
