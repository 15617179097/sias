package com.nice.service.impl;

import com.nice.mapper.UserRecordMapper;
import com.nice.pojo.UserRecord;
import com.nice.service.UserRecordService;
import com.nice.service.WxUserService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName UserRecordServiceImpl
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/9
 * @Version V1.0
 **/
@Service
public class UserRecordServiceImpl implements UserRecordService {
    @Autowired
    private UserRecordMapper userRecordMapper;
    @Autowired
    private WxUserService wxUserService;

    @Override
    public DataResult findUserRecordByUserId(String loginStateUUID) {

        UserRecord userRecord=new UserRecord();
        userRecord.setUserId( wxUserService.getWxUserId(loginStateUUID));
        List<UserRecord> userRecordByUserId = userRecordMapper.findUserRecordByUserId(userRecord);
        return DataResult.ok(userRecordByUserId);
    }
    /**
     * @Description 查询我的违约记录
     * @param request
     * @return com.nice.utils.DataResult
     **/
    @Override
    public DataResult findUserRecord(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");
        return DataResult.ok(userRecordMapper.findUserRecord(userId));
    }
}
