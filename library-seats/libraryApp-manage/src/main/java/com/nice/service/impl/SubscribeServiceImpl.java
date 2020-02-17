package com.nice.service.impl;

import com.nice.mapper.SignInMapper;
import com.nice.mapper.SubscribeMapper;
import com.nice.mapper.SuspendMapper;
import com.nice.pojo.SignIn;
import com.nice.pojo.Subscribe;
import com.nice.service.SubscribeService;
import com.nice.service.WxUserService;
import com.nice.utils.DataResult;
import com.nice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SubscribeServiceImpl implements SubscribeService {
    @Autowired
    private SubscribeMapper subscribeMapper;
    @Autowired
    private WxUserService wxUserService;
    @Autowired
    private SignInMapper signInMapper;
    @Autowired
    private SuspendMapper suspendMapper;
    @Override
    public List<Subscribe> findAllSubscribe() {
        List<Subscribe> allSubscribe = subscribeMapper.findAllSubscribe(null);
        return allSubscribe;
    }

    @Override
    public boolean saveSubscribe(String loginStateUUID,String createTime,String endTime,Integer seatsId,Integer classroomId){
        Subscribe subscribe=new Subscribe();
        int userId = wxUserService.getWxUserId(loginStateUUID);
        subscribe.setUserId(userId);
        subscribe.setCreateTime(createTime);
        subscribe.setEndTime(endTime);
        subscribe.setSeatsId(seatsId);
        subscribe.setClassroomId(classroomId);
        try {
            subscribeMapper.saveSubscribe(subscribe);
            SignIn signIn=new SignIn();
            signIn.setSubscribeId(subscribe.getId());
            signIn.setSignInTime(createTime);
            signInMapper.insertSignIn(signIn);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    //校验用户是否已经预约
    @Override
    public boolean checkSubscribe(String loginStateUUID) {
        int userId = wxUserService.getWxUserId(loginStateUUID);
        Subscribe subscribe=new Subscribe();
        subscribe.setUserId(userId);
        subscribe.setState(0);
        List<Subscribe> allSubscribe = subscribeMapper.findAllSubscribe(subscribe);
        if (allSubscribe.size()>0)
            return true;
    /*    List<Subscribe> subscribes = subscribeMapper.findSubscribe(DateUtil.TomorrowCreateTime(), DateUtil.TomorrowEndTime(),null, userId);
       if (subscribes.size()>0)
           return true;*/
        return false;
    }
    //查询我的预约
    @Override
    public DataResult findMySubscribe(String loginStateUUID) {
        int userId = wxUserService.getWxUserId(loginStateUUID);
        Map<String, Object> subscribe = subscribeMapper.findMySubscribe(userId);
        if(subscribe!=null)
            return DataResult.ok(subscribe);
        else
            return DataResult.ok();
    }

    @Override
    public DataResult delSubscribe(String loginStateUUID, Integer subscribeId) {
        int userId = wxUserService.getWxUserId(loginStateUUID);
        try {

            subscribeMapper.delSubscribe(subscribeId, DateUtil.getStringTime(),2);
            signInMapper.updateSignIn(2,subscribeId);
        }catch (Exception e){
            return DataResult.fail(500,"错误",e);
        }

        return DataResult.ok(true);
    }
}
