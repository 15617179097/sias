package com.nice.service.impl;

import com.nice.mapper.UserInfoMapper;
import com.nice.pojo.UserInfo;
import com.nice.service.UserInfoService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public DataResult findUserInfo() {
        return DataResult.ok(userInfoMapper.findUserInfo());
    }


}
