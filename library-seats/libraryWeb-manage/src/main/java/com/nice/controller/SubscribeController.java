package com.nice.controller;

import com.nice.pojo.Subscribe;
import com.nice.service.SubscribeService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;

    @PostMapping("subscribe")
    public DataResult insertSubscribe(Subscribe subscribe, HttpServletRequest request){
        String token = request.getHeader("Authorization");

        return subscribeService.insertSubscribe(subscribe,token);
    }

}
