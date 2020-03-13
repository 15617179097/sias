package com.nice.controller;
import com.nice.service.CheckLoginService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Company: 登陆  <br>
 * Description:  <br>
 * Date: 2020-01-12 23:01
 *
 * @author wmj
 * @version 1.0
 */

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class WxLoginController {
    @Autowired
    private CheckLoginService checkLoginService;

//    //用户登陆
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public DataResult login(String studentId,String password, HttpServletRequest request){
//
//        return checkLoginService.login(studentId,password,request);
//    }

    /**
     * @Description  wx登陆
     * @param code
     * @param request
     * @return com.nice.utils.DataResult
     **/
    @RequestMapping("/checkLogin")
    public DataResult checkLogin(String code, HttpServletRequest request){
        return checkLoginService.checkLogin(code, request);
    }

    /**
     * @Description wx注册
     * @param loginStateUUID
     * @param encryptedData
     * @param iv
     * @return com.nice.utils.DataResult
     **/
    @RequestMapping("/saveUserInfo")
    public DataResult saveUserInfo(String loginStateUUID,String encryptedData ,String iv){
        return  checkLoginService.saveUserInfo(loginStateUUID,encryptedData,iv);
    }
}
