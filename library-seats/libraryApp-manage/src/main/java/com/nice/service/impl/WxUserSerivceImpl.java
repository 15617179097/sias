package com.nice.service.impl;

import com.nice.mapper.WxUserInfoMapper;
import com.nice.service.RedisService;
import com.nice.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName WxUserSerivce
 * @Description: TODO
 * @Author wmj
 * @Date 2020/1/31
 * @Version V1.0
 **/
@Service
public class WxUserSerivceImpl implements WxUserService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private WxUserInfoMapper wxUserInfoMapper;
    /*
        获取缓存中的 用户id
     */
    @Override
    public int getWxUserId(String loginStateUUID) {
        String json = redisService.getV(loginStateUUID);
        int id = Integer.parseInt(json);
        return id;
    }
}
