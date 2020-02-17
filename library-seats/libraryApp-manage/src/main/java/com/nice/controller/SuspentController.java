package com.nice.controller;

import com.nice.service.SuspendService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suspend")
public class SuspentController {
    @Autowired
    private SuspendService suspendService;

    @RequestMapping(value = "/insertSuspend",method = RequestMethod.POST)
    public DataResult insertSuspend(Integer subscribeId,Integer time){

        return suspendService.insertSuspend(subscribeId,time);
    }
}
