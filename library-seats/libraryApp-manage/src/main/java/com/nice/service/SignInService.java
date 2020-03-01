package com.nice.service;

import com.nice.utils.DataResult;

/**
 * @ClassName SignInService
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/2
 * @Version V1.0
 **/
public interface SignInService {

    //签到记录
    public DataResult insertSignInById(Integer subscribeId);

    //未签
    public DataResult updateSignInById(Integer subscribeId);
}
