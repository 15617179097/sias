package com.nice.service;

import com.nice.utils.DataResult;

import javax.servlet.http.HttpServletRequest;

public interface CheckLoginService {
    public String checkLogin(String code, HttpServletRequest request);
    public DataResult saveUserInfo(String loginStateUUID, String encryptedData, String iv);
    public DataResult login(String studentId, String password, HttpServletRequest request);
}
