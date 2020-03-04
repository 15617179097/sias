package com.nice.controller;

import com.nice.utils.DataResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName WxUserController
 * @Description: TODO
 * @Author wmj
 * @Date 2020/3/3
 * @Version V1.0
 **/
@RestController
public class WxUserController {

    @GetMapping("users")
    public DataResult findWxUser(){
        return null;
    }
}
