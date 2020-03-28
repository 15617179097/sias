package com.nice.web.service.impl;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.web.mapper.UserInfoMapper;
import com.nice.web.pojo.Admin;
import com.nice.web.pojo.SignIn;
import com.nice.web.pojo.Subscribe;
import com.nice.web.utils.DataResult;
import com.nice.web.mapper.SignInMapper;
import com.nice.web.mapper.SubscribeMapper;
import com.nice.web.service.AdminService;
import com.nice.web.service.SubscribeService;
import com.nice.web.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private UserInfoMapper userInfoMapper;
    @Autowired
    private SubscribeMapper subscribeMapper;
    @Autowired
    private SignInMapper signInMapper;

    /**
     * @Description 预约座位
     * @param subscribe
     * @param token
     * @return com.nice.web.utils.DataResult
     **/
    @Override
    public DataResult insertSubscribe(Subscribe subscribe, String token,String studentId) {
        Admin adminByToken = adminService.findAdminByToken(token);
        if(adminByToken==null)
            return DataResult.fail(401,"token失效!!",null);
        String createTime = subscribe.getCreateTime();

        long createTimel = DateUtil.StringToLong(createTime) ;

        long nowEndTimel = DateUtil.StringToLong(DateUtil.nowEndTime());
        List<Subscribe> subscribeSeats =null;
        if(createTimel<nowEndTimel) {
            subscribeSeats = subscribeMapper.findSubscribeSeats(DateUtil.nowCreateTime(), DateUtil.nowEndTime(), subscribe.getClassroomId(), subscribe.getCreateTime());
        } else
            subscribeSeats = subscribeMapper.findSubscribeSeats(DateUtil.TomorrowCreateTime(), DateUtil.TomorrowEndTime(),subscribe.getClassroomId(), subscribe.getCreateTime());
        for (Subscribe s:subscribeSeats){
            if(s.getClassroomId().equals(subscribe.getClassroomId())&&s.getSeatsId().equals(subscribe.getSeatsId())){
                return DataResult.fail(500,"",null);
            }
        }
        List<Map<String, Object>> userInfo = userInfoMapper.findUserInfo(studentId);
        subscribe.setUserId((Integer) userInfo.get(0).get("id"));
        subscribeMapper.insertSubscribe(subscribe);
        SignIn signIn=new SignIn();
        signIn.setSubscribeId(subscribe.getId());
        signIn.setSignInTime(subscribe.getCreateTime());
        signInMapper.insertSignIn(signIn);
        return DataResult.ok();
    }
    /**
     * @Description 查询预约列表
     * @param query
     * @param pagenum
     * @param pagesize
     * @param stundentId
     * @return com.nice.web.utils.DataResult
     **/
    @Override
    public DataResult findSubscribe(String query, int pagenum, int pagesize,String stundentId) {
        PageHelper.startPage(pagenum,pagesize);
        List<Map<String, Object>> subscribe = subscribeMapper.findSubscribe(query);
        PageInfo<Map<String, Object>> info = new PageInfo<>(subscribe);
        Map<String, Object> map = new HashMap<>();
        map.put("total",info.getTotal());
        map.put("subscribeList",info.getList());
        return DataResult.ok(map);
    }

    /**
     * @Description 结束预约
     * @param id 预约id
     * @return com.nice.web.utils.DataResult
     **/
    @Override
    public DataResult overSubscribe(int id) {
        signInMapper.overSignIn(id);
        subscribeMapper.overSubscribe(id);
        return DataResult.ok();
    }
}
