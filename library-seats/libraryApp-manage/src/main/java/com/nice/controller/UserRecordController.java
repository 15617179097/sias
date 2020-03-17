package com.nice.controller;

import com.nice.service.UserRecordService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserRecordController
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/9
 * @Version V1.0
 **/
@RestController
public class UserRecordController {

    @Autowired
    private UserRecordService userRecordService;

    /**
     * @Description 查询我的违约记录
     * @param request
     * @return com.nice.utils.DataResult
     **/
    @GetMapping("userRecord")
    public DataResult findUserRecord(HttpServletRequest request){
        return userRecordService.findUserRecord(request);
    }
}
