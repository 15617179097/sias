package com.nice.web.controller;

import com.nice.web.service.UserFeedbackService;
import com.nice.web.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-28 21:31
 *
 * @author wmj
 * @version 1.0
 */
@RestController
public class UserFeedbackController {

    @Autowired
    private UserFeedbackService userFeedbackService;
    /**
     * @Description 获取监督占位列表
     * @param pagenum
     * @param pagesize
     * @param query
     * @return com.nice.web.utils.DataResult
     **/
    @GetMapping("userFeedback")
    public DataResult findUserFeedback(
            @RequestParam("pagenum")int pagenum,
            @RequestParam("pagesize")int pagesize,
            String query){
        return userFeedbackService.findUserFeedback(query,pagenum,pagesize);
    }

    /**
     * @Description 完成监督占位工作
     * @param id
     * @return com.nice.web.utils.DataResult
     **/
    @PutMapping("userFeedback/{id}")
    public DataResult findUserFeedback(@PathVariable("id")int id){
        return userFeedbackService.updateUserFeedback(id);
    }
}
