package com.nice.controller;

import com.nice.service.SuspendService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Company: 暂离  <br>
 * Description:  <br>
 * Date: 2020-01-12 23:01
 *
 * @author wmj
 * @version 1.0
 */

@RestController
@RequestMapping("/suspend")
public class SuspentController {

    @Autowired
    private SuspendService suspendService;

    /**
     * @Description 暂离
     * @param subscribeId
     * @param time
     * @return com.nice.utils.DataResult
     **/
    @PostMapping("/add")
    public DataResult insertSuspend(Integer subscribeId,Integer time){
        return suspendService.insertSuspend(subscribeId,time);
    }
}
