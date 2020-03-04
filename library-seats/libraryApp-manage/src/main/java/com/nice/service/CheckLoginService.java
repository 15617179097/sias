package com.nice.service;

import com.nice.utils.DataResult;

import javax.servlet.http.HttpServletRequest;

public interface CheckLoginService {
    //微信获取openid
    public DataResult checkLogin(String code, HttpServletRequest request);

    //微信登陆
    public DataResult saveUserInfo(String loginStateUUID, String encryptedData, String iv);

    //用户登陆
    public DataResult login(String studentId, String password, HttpServletRequest request);
}
