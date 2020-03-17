package com.nice.service.impl;

import com.nice.mapper.SignInMapper;
import com.nice.mapper.SubscribeMapper;
import com.nice.mapper.UserInfoMapper;
import com.nice.mapper.UserRecordMapper;
import com.nice.pojo.Subscribe;
import com.nice.pojo.UserRecord;
import com.nice.service.SignInService;
import com.nice.utils.DataResult;
import com.nice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName SignInServiceImpl
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/2
 * @Version V1.0
 **/
@Service
public class SignInServiceImpl implements SignInService {
    @Autowired
    private SignInMapper signInMapper;
    @Autowired
    private SubscribeMapper subscribeMapper;
    @Autowired
    private UserRecordMapper userRecordMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    /*
        记录签到
     */
    @Override
    public DataResult insertSignInById(Integer subscribeId) {
        signInMapper.updateSignIn(1,subscribeId);
        return DataResult.ok();
    }

    /*
        未签到 进行记录
     */
    @Override
    public DataResult updateSignInById(Integer subscribeId) {
        try {
            signInMapper.updateSignIn(4,subscribeId);
            Subscribe subscribe=new Subscribe();
            subscribe.setId(subscribeId);
            List<Subscribe> allSubscribe1 = subscribeMapper.findAllSubscribe(subscribe);
            UserRecord userRecord=new UserRecord();
            userRecord.setUserId(allSubscribe1.get(0).getUserId());
            userRecord.setSubscribeId(subscribeId);
            userRecord.setIllegalTime(DateUtil.DateToString(new Date()));
            userRecordMapper.insertUserRecord(userRecord);
            userInfoMapper.updateUserInfoCreditScore();
            subscribeMapper.delSubscribe(subscribeId,null,1);

        }catch (Exception e){
            e.printStackTrace();
            return DataResult.fail(500,"错误",e);
        }
        return DataResult.ok();
    }
}
