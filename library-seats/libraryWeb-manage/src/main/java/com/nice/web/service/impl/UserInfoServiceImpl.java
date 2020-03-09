package com.nice.web.service.impl;

import com.nice.web.utils.DataResult;
import com.nice.web.mapper.UserInfoMapper;
import com.nice.web.service.UserInfoService;
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
    /**
     * @Description 获取用户信息
     * @param
     * @return com.nice.web.utils.DataResult
     **/
    @Override
    public DataResult findUserInfo() {
        return DataResult.ok(userInfoMapper.findUserInfo());
    }


}
