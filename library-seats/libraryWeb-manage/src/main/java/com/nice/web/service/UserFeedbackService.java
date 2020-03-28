package com.nice.web.service;

import com.nice.web.utils.DataResult;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-28 21:54
 *
 * @author wmj
 * @version 1.0
 */
public interface UserFeedbackService {

    //获取用户反馈列表
    DataResult findUserFeedback(String query, int pagenum, int pagesize);

    //完成
    DataResult updateUserFeedback(int id);
}
