package com.nice.service;

import com.nice.pojo.Subscribe;
import com.nice.utils.DataResult;

import java.text.ParseException;
import java.util.List;
/**
 * @ClassName SignInService
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/2
 * @Version V1.0
 **/
public interface SubscribeService {

    //查询所有预约信息
    public List<Subscribe> findAllSubscribe();

    //预约记录
    public boolean saveSubscribe(String loginStateUUID, String creteTime, String endTime, Integer seatsId, Integer classroomId) throws ParseException;

    //检验当前是否预约
    public boolean checkSubscribe(String loginStateUUID);

    //查询用户预约信息
    public DataResult findMySubscribe(String loginStateUUID);

    //取消预约
    public DataResult delSubscribe(String loginStateUUID, Integer subscribeId);
}
