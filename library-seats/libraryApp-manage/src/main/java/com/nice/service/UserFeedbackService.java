package com.nice.service;

import com.nice.pojo.UserFeedback;
import com.nice.utils.DataResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-16 23:12
 *
 * @author wmj
 * @version 1.0
 */
public interface UserFeedbackService {

    //用户反馈
    DataResult insertUserFeedback(String email,String text, HttpServletRequest request);
}
