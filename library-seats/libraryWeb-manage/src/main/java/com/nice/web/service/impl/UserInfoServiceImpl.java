package com.nice.web.service.impl;

import com.nice.web.pojo.UserInfo;
import com.nice.web.utils.DataResult;
import com.nice.web.mapper.UserInfoMapper;
import com.nice.web.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserInfoServiceImpl
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/23
 * @Version V1.0
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    /**
     * @Description 获取用户信息
     * @param
     * @return com.nice.web.utils.DataResult
     **/
    @Override
    public DataResult findUserInfo() {
        return DataResult.ok(userInfoMapper.findUserInfo(null));
    }

    @Override
    public DataResult insertUserinfo(String studentId, String name) {
        List<Map<String, Object>> info = userInfoMapper.findUserInfo(studentId);
        if (info.size()>0)
            return DataResult.ok();
        UserInfo userInfo= new UserInfo();
        userInfo.setStudentId(studentId);
        userInfo.setName(name);
        userInfo.setUerId(0);
        userInfoMapper.insertUserInfo(userInfo);
        return DataResult.ok();
    }


}
