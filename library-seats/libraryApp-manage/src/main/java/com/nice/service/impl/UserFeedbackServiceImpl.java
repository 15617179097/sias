package com.nice.service.impl;

import com.nice.mapper.UserFeedbackMapper;
import com.nice.pojo.UserFeedback;
import com.nice.service.UserFeedbackService;
import com.nice.utils.DataResult;
import com.nice.utils.DateUtil;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-16 23:12
 *
 * @author wmj
 * @version 1.0
 */
@Service
public class UserFeedbackServiceImpl implements UserFeedbackService {
    @Autowired
    private UserFeedbackMapper userFeedbackMapperl;
    @Override
    public DataResult insertUserFeedback(String email, String text, HttpServletRequest request) {
        UserFeedback userFeedback = new UserFeedback();
        userFeedback.setEmail(email);
        userFeedback.setFeedbackText(text);
        userFeedback.setUserId((Integer) request.getAttribute("userId"));
        userFeedback.setCreateTime(DateUtil.DateToString(new Date()));
        try {
            userFeedbackMapperl.insertUserFeedback(userFeedback);
        }catch (Exception e){
            return DataResult.fail(500,"",e);
        }

        return DataResult.ok();
    }
}
