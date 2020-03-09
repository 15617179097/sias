package com.nice.web.controller;

import com.nice.web.pojo.Subscribe;
import com.nice.web.service.SubscribeService;
import com.nice.web.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    /**
     * @Description 进行预约座位
     * @param subscribe
     * @param request
     * @return com.nice.web.utils.DataResult
     **/
    @PostMapping("subscribe")
    public DataResult insertSubscribe(Subscribe subscribe, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        return subscribeService.insertSubscribe(subscribe,token);
    }

}
