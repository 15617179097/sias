package com.nice.service;

import com.nice.utils.DataResult;

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
    DataResult findUserByLoginStateUUid(String loginStateUUID);

    // 添加学号
    DataResult saveUserByLoginStateUUid(String loginStateUUID, String studentId);

    //查询我的违约记录
    DataResult findUserRecordByUserId(String loginStateUUID);

    //查询我的预约记录
    DataResult findMyAllSubscribe(String loginStateUUID);

    //用户列表
    DataResult findAllUsers();
}
