package com.nice.service.impl;

import com.nice.mapper.SignInMapper;
import com.nice.mapper.SubscribeMapper;
import com.nice.pojo.Admin;
import com.nice.pojo.SignIn;
import com.nice.pojo.Subscribe;
import com.nice.service.AdminService;
import com.nice.service.SubscribeService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-07 10:22
 *
 * @author wmj
 * @version 1.0
 */
@Service
public class SubscribeServiceImpl implements SubscribeService {
    @Autowired
    private AdminService adminService;
    @Autowired
    private SubscribeMapper subscribeMapper;
    @Autowired
    private SignInMapper signInMapper;
    /*预约座位*/
    @Override
    public DataResult insertSubscribe(Subscribe subscribe, String token) {
        Admin adminByToken = adminService.findAdminByToken(token);
        if(adminByToken==null)
            return DataResult.fail(401,"token失效!!",null);
        subscribe.setUserId(adminByToken.getUserId());
        subscribeMapper.insertSubscribe(subscribe);
        SignIn signIn=new SignIn();
        signIn.setSubscribeId(subscribe.getId());
        signIn.setSignInTime(subscribe.getCreateTime());
        signInMapper.insertSignIn(signIn);
        return DataResult.ok();
    }
}
