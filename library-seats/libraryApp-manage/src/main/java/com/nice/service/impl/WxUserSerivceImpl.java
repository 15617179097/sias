package com.nice.service.impl;

import com.nice.mapper.UserInfoMapper;
import com.nice.mapper.WxUserInfoMapper;
import com.nice.pojo.UserInfo;
import com.nice.pojo.WxUserInfo;
import com.nice.service.RedisService;
import com.nice.service.WxUserService;
import com.nice.utils.JsonUtils;
import com.nice.utils.WxCheckPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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
    @Autowired
    private UserInfoMapper userInfoMapper;
    /*
        获取缓存中的 用户id
     */
    @Override
    public int getWxUserId(String loginStateUUID) {

        String json = redisService.getV(loginStateUUID);
        WxCheckPojo parse = JsonUtils.jsonToPojo(json,WxCheckPojo.class);
        WxUserInfo wxUserInfoByOpenId = wxUserInfoMapper.findWxUserInfoByOpenId(parse.getOpenid());
        UserInfo userInfos = new UserInfo();
        userInfos.setUerId(wxUserInfoByOpenId.getId());
        Map<String, Object> userInfo = userInfoMapper.findUserInfo(userInfos);
        if (userInfo==null){
            return 0;
        }
        return (int) userInfo.get("id");
    }
}
