package com.nice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        Admin adminList = adminMapper.findAdminAndLogin(admin);
        //校验账号密码是否正确
        if (!adminList.getPassword().equals(password))
            return DataResult.fail(500,"账号密码错误,请重新输入",null);
        Map<String, Object> token = getToken(adminList);
        return DataResult.ok(token);
    }
    /*查询密码以及用户信息*/
    @Override
    public DataResult findAdminAndPwd(Integer id) {
        Admin admin = new Admin();
        admin.setId(id);
        return DataResult.ok(adminMapper.findAdminAndLogin(admin));
    }

    /*查询用户列表*/
    @Override
    public DataResult adminList(String username,Integer pagenum,Integer pagesize) {
        //分页插件
        PageHelper.startPage(pagenum,pagesize);
         Admin admins=new Admin();
        admins.setUsername(username);
        List<Admin> admin = adminMapper.findAdmin(admins);
        PageInfo<Admin> adminList = new PageInfo<Admin>(admin);
        Map<String, Object> map =new HashMap<>();
        map.put("admins",adminList);
        map.put("total",adminList.getTotal());
        return DataResult.ok(map);
    }

    /*添加用户*/
    @Override
    public DataResult insertAdmin(Admin admin) {
        try{
            adminMapper.insertAdmin(admin);
        }catch (Exception e){
            return DataResult.fail(500,"修改失败！",e);
        }
        return DataResult.ok();
    }

    /*修改信息*/
    @Override
    public DataResult updetaAdmin(Integer id, Admin admin) {
        admin.setId(id);
        try{
            adminMapper.updataAdmin(admin);
        }catch (Exception e){
            return DataResult.fail(500,"修改失败！",e);
        }
        return DataResult.ok();
    }

    //修改用户状态
    @Override
    public DataResult updataAdminStatus(Integer id, Integer status) {
        Admin admin=new Admin();
        admin.setId(id);
        admin.setStatus(status);
        try {
            adminMapper.updataAdminStatus(admin);
        }catch (Exception e) {
            return DataResult.fail(500,"修改失败！",e);
        }
        return DataResult.ok();
    }

    //删除用户
    @Override
    public DataResult daleteAdmin(Integer id) {
        try {
            adminMapper.daleteAdmin(id);
        }catch(Exception e){
            return DataResult.fail(500,"删除失败！！",e);
        }
        return DataResult.ok();
    }

    //获取token
    private Map<String,Object> getToken(Admin admins){
        String token = UUID.randomUUID().toString();
        redisService.setV(token,admins.getId().toString());
        Map<String,Object> reslt=new HashMap<>();
        reslt.put("token",token);
        return reslt;
    }
}
