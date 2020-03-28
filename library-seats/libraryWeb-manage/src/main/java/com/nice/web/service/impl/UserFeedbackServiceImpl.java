package com.nice.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.web.mapper.UserFeedbackMapper;
import com.nice.web.service.UserFeedbackService;
import com.nice.web.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-28 21:55
 *
 * @author wmj
 * @version 1.0
 */
@Service
public class UserFeedbackServiceImpl implements UserFeedbackService {

    @Autowired
    private UserFeedbackMapper userFeedbackMapper;
    /**
     * @Description 获取用户反馈列表
     * @param query
     * @param pagenum
     * @param pagesize
     * @return com.nice.web.utils.DataResult
     **/
    @Override
    public DataResult findUserFeedback(String query, int pagenum, int pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<Map<String, Object>> userFeedback = userFeedbackMapper.findUserFeedback(query);
        PageInfo<Map<String, Object>> info = new PageInfo<>(userFeedback);
        Map<String, Object> map = new HashMap<>();
        map.put("userFeedbackList",info.getList());
        map.put("total",info.getTotal());
        return DataResult.ok(map);
    }
    /**
     * @Description 完成反馈
     * @param id
     * @return com.nice.web.utils.DataResult
     **/
    @Override
    public DataResult updateUserFeedback(int id) {
        userFeedbackMapper.updateUserFeedback(id);
        return DataResult.ok();
    }
}
