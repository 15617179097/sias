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
    public DataResult insertSignInById(Integer subscribeId);
    public DataResult updateSignInById(Integer subscribeId);
}
