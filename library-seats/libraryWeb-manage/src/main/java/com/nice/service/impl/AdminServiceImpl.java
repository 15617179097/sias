package com.nice.service.impl;

import com.nice.mapper.AdminMapper;
import com.nice.pojo.Admin;
import com.nice.service.AdminService;
import com.nice.service.RedisService;
import com.nice.utils.DataResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName AdminServiceImpl
 * @Description: TODO
 * @Author wmj
 * @Date 2020/3/1
 * @Version V1.0
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RedisService redisService;
    //后台登陆
    @Override
    public DataResult adminLogin(String username,String password) {
        //校验是否为空
        if(StringUtils.isBlank(username) && StringUtils.isBlank(password))
            return DataResult.fail(500,"账号密码不能为空",null);
        Admin admin=new Admin();
        admin.setUsername(username);
        List<Admin> adminList = adminMapper.findAdmin(admin);
        //校验账号账号是否存在
        if(adminList.size()<=0)
            return DataResult.fail(500,"账号密码错误,请重新输入",null);
        Admin admins = adminList.get(0);
        //校验账号密码是否正确
        if (!admins.getPassword().equals(password))
            return DataResult.fail(500,"账号密码错误,请重新输入",null);
        Map<String, Object> token = getToken(admins);
        return DataResult.ok(token);
    }

    @Override
    public DataResult adminList() {
        return DataResult.ok(adminMapper.findAdmin(null));
    }

    private Map<String,Object> getToken(Admin admins){
        String token = UUID.randomUUID().toString();
        redisService.setV(token,admins.getId().toString());
        Map<String,Object> reslt=new HashMap<>();
        reslt.put("token",token);
        return reslt;
    }
}
