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

import javax.servlet.http.HttpServletRequest;
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
    private UserRecordMapper userRecordMapper;
    @Autowired
    private SubscribeMapper subscribeMapper;
    @Override
    public DataResult findUserByLoginStateUUid(HttpServletRequest request) {
        UserInfo userInfo=new UserInfo();
        userInfo.setUerId((Integer) request.getAttribute("token"));
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
    public DataResult saveUserByLoginStateUUid(HttpServletRequest request, String studentId) {
        UserInfo userInfo=new UserInfo();
        userInfo.setStudentId(studentId);
        userInfo.setUerId((Integer) request.getAttribute("userId"));
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
    public DataResult findUserRecordByUserId(HttpServletRequest request) {
        UserRecord userRecord=new UserRecord();
        userRecord.setUserId( (Integer) request.getAttribute("userId"));
        List<UserRecord> userRecordByUserId = userRecordMapper.findUserRecordByUserId(userRecord);
        return DataResult.ok(userRecordByUserId);
    }

    @Override
    public DataResult findMyAllSubscribe(HttpServletRequest request) {
        return DataResult.ok(subscribeMapper.findMyAllSubscribe((Integer) request.getAttribute("userId")));
    }

    @Override
    public DataResult findAllUsers() {
        return DataResult.ok(userMapper.findAllUsers());
    }

    /**
     * @Description 删除用户绑定信息
     * @param request
     * @return com.nice.utils.DataResult
     **/
    @Override
    public DataResult deleteUserInfo(HttpServletRequest request) {
        try{
            Integer token = (Integer) request.getAttribute("userId");
            userMapper.deleteUserInfo(token);
        }catch (Exception e){
            return DataResult.fail(500,"删除失败！",e);
        }
        return DataResult.ok();
    }

}
