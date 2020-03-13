package com.nice.service;

import com.nice.utils.DataResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-13 15:13
 *
 * @author wmj
 * @version 1.0
 */
public interface UserService {

    //查询用户信息
    DataResult findUserByLoginStateUUid(HttpServletRequest request);

    // 添加学号
    DataResult saveUserByLoginStateUUid(HttpServletRequest request, String studentId);

    //查询我的违约记录
    DataResult findUserRecordByUserId(HttpServletRequest request);

    //查询我的预约记录
    DataResult findMyAllSubscribe(HttpServletRequest request);

    //用户列表
    DataResult findAllUsers();

    //删除用户信息
    DataResult deleteUserInfo(HttpServletRequest request);
}
