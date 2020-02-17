package com.nice.controller;

import com.nice.service.SignInService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signIn")
public class SignInController {
    @Autowired
    private SignInService signInService;

    @RequestMapping(value = "/insertSignIn",method = RequestMethod.POST)
    public DataResult insertSignInById(Integer subscribeId){

        return signInService.insertSignInById(subscribeId);
    }
    @RequestMapping(value = "/updateSignInById",method = RequestMethod.POST)
    public DataResult updateSignInById(Integer subscribeId){

        return signInService.updateSignInById(subscribeId);
    }
}
