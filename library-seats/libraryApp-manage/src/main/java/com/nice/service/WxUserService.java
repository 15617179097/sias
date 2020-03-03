package com.nice.service;

/**
 * @ClassName WxUserService
 * @Description: TODO
 * @Author wmj
 * @Date 2020/1/31
 * @Version V1.0
 **/
public interface WxUserService {
    //获取openid
    int getWxUserId(String loginStateUUID);
}
