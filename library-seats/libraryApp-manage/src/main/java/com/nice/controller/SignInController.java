package com.nice.controller;

import com.nice.service.SignInService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Company: 签到  <br>
 * Description:  <br>
 * Date: 2020-01-12 23:01
 *
 * @author wmj
 * @version 1.0
 */
@RestController
@RequestMapping("/signIn")
public class SignInController {
    @Autowired
    private SignInService signInService;

    /**
     * @Description 签到
     * @param subscribeId
     * @return com.nice.utils.DataResult
     **/
    @PostMapping("/{subscribeId}")
    public DataResult insertSignInById(Integer subscribeId){

        return signInService.insertSignInById(subscribeId);
    }

    //修改签到
    @PostMapping("/updateSignInById" )
    public DataResult updateSignInById(Integer subscribeId){

        return signInService.updateSignInById(subscribeId);
    }
}
