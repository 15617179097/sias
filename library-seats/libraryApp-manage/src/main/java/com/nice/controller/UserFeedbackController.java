package com.nice.controller;

import com.nice.pojo.UserFeedback;
import com.nice.service.UserFeedbackService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Company:  <br>
 * Description: 用户反馈 <br>
 * Date: 2020-03-16 22:37
 *
 * @author wmj
 * @version 1.0
 */

@RestController
public class UserFeedbackController {

    @Autowired
    private UserFeedbackService userFeedbackService;

    @PostMapping("userFeedback")
    public DataResult insertUserFeedback(String email, String text, HttpServletRequest request){

        return userFeedbackService.insertUserFeedback(email,text,request);
    }
}
