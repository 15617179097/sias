package com.nice.service.impl;

import com.nice.mapper.UserInfoMapper;
import com.nice.mapper.WxUserInfoMapper;
import com.nice.pojo.UserInfo;
import com.nice.pojo.WxUserInfo;
import com.nice.service.CheckLoginService;
import com.nice.service.RedisService;
import com.nice.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

@Service
public class CheckLoginServiceImpl implements CheckLoginService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private WxUserInfoMapper wxUserInfoMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    //登陆
    @Override
    public String checkLogin(String code, HttpServletRequest request) {
        StringBuffer url=new StringBuffer("https://api.weixin.qq.com/sns/jscode2session?");
        url.append("&appid=");
        url.append("wxab05f784f49f7837");
        url.append("&secret=");
        url.append("e6ffe00dbeb7c44abd21b1b0bf90e87e");
        url.append("&js_code=");
        url.append(code);
        url.append("&grant_type=authorization_code");
        String sessionData = HttpClientUtil.httpsRequestToString(url.toString(), "GET", null);
        UUID token= UUID.randomUUID();
        redisService.setV(token.toString(),sessionData);
        return token.toString();
    }

    //注册
    @Override
    public DataResult saveUserInfo(String loginStateUUID,String encryptedData ,String iv) {
       //根据登陆标识loginStateUUID 从缓存中查询数据
        String json = redisService.getV(loginStateUUID);
        //判断是否过期
        if (!StringUtils.isBlank(json)){
            WxCheckPojo wxCheckPojo = JsonUtils.jsonToPojo(json, WxCheckPojo.class);
            //用户数据解密
            String userInfoJson = WxUtil.getUserInfo(encryptedData, wxCheckPojo.getSession_key(), iv);
            WxUserInfo userInfo=JsonUtils.jsonToPojo(userInfoJson, WxUserInfo.class);
            //查询是否存在
            WxUserInfo info = wxUserInfoMapper.findWxUserInfoByOpenId(wxCheckPojo.getOpenid());
            if (info==null){
                //第一次登陆 进行注册
                wxUserInfoMapper.insertUserInfo(userInfo);
            }else{
                //更新信息
                userInfo.setId(info.getId());
                wxUserInfoMapper.updataUserInfo(userInfo);
            }
        }else {
            //登陆态过期
        }
        return null;
    }

    @Override
    public DataResult login(String studentId, String password, HttpServletRequest request) {
        UserInfo userInfo=new UserInfo();
        userInfo.setStudentId(studentId);
        Map<String, Object> login = userInfoMapper.login(userInfo);
        if (login==null){
            return DataResult.ok();
        }
        if (login.get("password").equals(password)){
            UUID token= UUID.randomUUID();
            redisService.setV(token.toString(),login.get("id").toString());
            redisService.expire(token.toString(),0);
            return DataResult.ok(token.toString());
        }
        return DataResult.ok();
    }
}
