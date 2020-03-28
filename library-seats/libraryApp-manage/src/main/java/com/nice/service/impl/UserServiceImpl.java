package com.nice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.mapper.SubscribeMapper;
import com.nice.mapper.UserInfoMapper;
import com.nice.mapper.UserRecordMapper;
import com.nice.pojo.UserInfo;
import com.nice.pojo.UserRecord;
import com.nice.service.UserService;
import com.nice.service.WxUserService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-13 15:14
 *
 * @author wmj
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userMapper;
    @Autowired
    private UserRecordMapper userRecordMapper;
    @Autowired
    private SubscribeMapper subscribeMapper;
    @Override
    public DataResult findUserByLoginStateUUid(HttpServletRequest request) {
        UserInfo userInfo=new UserInfo();
        userInfo.setId((Integer) request.getAttribute("userId"));
        Map<String,Object> user = userMapper.findUserInfo(userInfo);
        if (user==null)
            return DataResult.ok();
        else
            return DataResult.ok(user);
    }

    /**
     * @Description 添加学号
     * @param request
     * @param studentId
     * @return com.nice.utils.DataResult
     **/
    @Override
    public DataResult saveUserByLoginStateUUid(HttpServletRequest request, String studentId) {
        UserInfo userInfo=new UserInfo();
        userInfo.setStudentId(studentId);
        userInfo.setId((Integer) request.getAttribute("userId"));
        Map<String,Object> info =null;
        try {
            info = userMapper.findUserInfo(userInfo);
            if (info==null) {
                userMapper.insertUserInfo(userInfo);
                info =userMapper.findUserInfo(userInfo);
            }
            else {
                userMapper.updateUserInfo((Integer) request.getAttribute("userId"),studentId);
                info.put("studentId",studentId);
            }
        }catch (Exception e){
            DataResult.fail(500,"error",e);
        }
        return DataResult.ok(info);
    }

    /**
     * @Description 查询用户违约信息
     * @param request
     * @return com.nice.utils.DataResult
     **/
    @Override
    public DataResult findUserRecordByUserId(HttpServletRequest request) {
        UserRecord userRecord=new UserRecord();
        userRecord.setUserId((Integer) request.getAttribute("userId"));
        List<UserRecord> userRecordByUserId = userRecordMapper.findUserRecordByUserId(userRecord);
        return DataResult.ok(userRecordByUserId);
    }

    /**
     * @Description 查询用户所有预约信息
     * @param request
     * @return com.nice.utils.DataResult
     **/
    @Override
    public DataResult findMyAllSubscribe(HttpServletRequest request,Integer pagenum,Integer pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<Map<String, Object>> userId = subscribeMapper.findMyAllSubscribe((Integer) request.getAttribute("userId"));
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(userId);
        Map<String,Object> map= new HashMap<>();
        map.put("allSubscribe",pageInfo.getList());
        map.put("total",pageInfo.getPages());
        return DataResult.ok(map);
    }

    @Override
    public DataResult findAllUsers() {
        return DataResult.ok(userMapper.findAllUsers());
    }

    /**
     * @Description 删除用户绑定信息
     * @param request
     * @return com.nice.utils.DataResult
     **/
    @Override
    public DataResult deleteUserInfo(HttpServletRequest request) {
        try{
            Integer userId = (Integer) request.getAttribute("userId");
            userMapper.updateUserInfo(userId,null);
        }catch (Exception e){
            return DataResult.fail(500,"删除失败！",e);
        }
        return DataResult.ok();
    }

}
