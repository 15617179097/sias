package com.nice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.mapper.UserInfoMapper;
import com.nice.mapper.WxUserMapper;
import com.nice.pojo.UserInfo;
import com.nice.service.WxUserService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName WxUserServiceImpl
 * @Description: TODO
 * @Author wmj
 * @Date 2020/3/4
 * @Version V1.0
 **/
@Service
public class WxUserServiceImpl implements WxUserService {

    @Autowired
    private WxUserMapper wxUserMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    //查询微信用户列表
    @Override
    public DataResult findWxUser(Integer studentId,Integer pagenum,Integer pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<Map<String, Object>> wxUser = wxUserMapper.findWxUser(studentId);
        PageInfo<Map<String, Object>> pageInfo= new PageInfo<>(wxUser);
        Map<String,Object> res=new HashMap<>();
        res.put("infoList",pageInfo.getList());
        res.put("total",pageInfo.getTotal());
        return DataResult.ok(res);
    }

    //禁用 开启用户
    @Override
    public DataResult updataWxUserState(Integer id,Integer state) {
        UserInfo userInfo = new UserInfo();
        userInfo.setState(state);
        userInfo.setUerId(id);
        try{
            userInfoMapper.updateUserInfoState(userInfo);
        }catch(Exception e){
            return DataResult.fail(500,"状态修改失败！",e);
        }
        return DataResult.ok();
    }

    //禁用 开启用户
    @Override
    public DataResult deleteUserInfo(Integer id) {
        try{
            userInfoMapper.deleteUserInfo(id);
        }catch(Exception e){
            return DataResult.fail(500,"删除信息失败！",e);
        }
        return DataResult.ok();
    }
}
