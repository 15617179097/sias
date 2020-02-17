package com.nice.service;

import com.nice.utils.DataResult;

/**
 * @ClassName SignInService
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/2
 * @Version V1.0
 **/
public interface SuspendService {
    public DataResult insertSuspend(Integer subscribeId, Integer time);
}
