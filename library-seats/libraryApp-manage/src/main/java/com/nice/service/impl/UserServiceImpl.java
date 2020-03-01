package com.nice.service.impl;

import com.nice.mapper.SubscribeMapper;
import com.nice.mapper.UserInfoMapper;
import com.nice.mapper.UserRecordMapper;
import com.nice.pojo.UserInfo;
import com.nice.pojo.UserRecord;
import com.nice.service.UserService;
import com.nice.service.WxUserService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-13 15:14
 *
 * @author wmj
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userMapper;
    @Autowired
    private WxUserService wxUserService;
    @Autowired
    private UserRecordMapper userRecordMapper;
    @Autowired
    private SubscribeMapper subscribeMapper;
    @Override
    public DataResult findUserByLoginStateUUid(String loginStateUUID) {
        int userId = wxUserService.getWxUserId(loginStateUUID);
        UserInfo userInfo=new UserInfo();
        userInfo.setUerId(userId);
        Map<String,Object> user = userMapper.findUserInfo(userInfo);
        if (user==null)
            return DataResult.ok();
        else
            return DataResult.ok(user);
    }

    /*
        添加学号
     */
    @Override
    public DataResult saveUserByLoginStateUUid(String loginStateUUID, String studentId) {
        int userId = wxUserService.getWxUserId(loginStateUUID);
        UserInfo userInfo=new UserInfo();
        userInfo.setStudentId(studentId);
        userInfo.setUerId(userId);
        Map<String,Object> info =null;
        try {
            userMapper.insertUserInfo(userInfo);
            info =userMapper.findUserInfo(userInfo);
        }catch (Exception e){
            DataResult.fail(500,"error",e);
        }
        return DataResult.ok(info);
    }

    @Override
    public DataResult findUserRecordByUserId(String loginStateUUID) {
        UserRecord userRecord=new UserRecord();
        userRecord.setUserId( wxUserService.getWxUserId(loginStateUUID));
        List<UserRecord> userRecordByUserId = userRecordMapper.findUserRecordByUserId(userRecord);
        return DataResult.ok(userRecordByUserId);
    }

    @Override
    public DataResult findMyAllSubscribe(String loginStateUUID) {
        return DataResult.ok(subscribeMapper.findMyAllSubscribe( wxUserService.getWxUserId(loginStateUUID)));
    }

    @Override
    public DataResult findAllUsers() {
        return DataResult.ok(userMapper.findAllUsers());
    }

}
