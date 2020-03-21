package com.nice.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.web.pojo.Admin;
import com.nice.web.utils.DataResult;
import com.nice.web.utils.JsonUtils;
import com.nice.web.mapper.AdminMapper;
import com.nice.web.service.AdminService;
import com.nice.web.service.RedisService;
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

    /**
     * @Description 后台登陆
     * @Param username, pagenum, pagesize
     * @return
     **/
    @Override
    public DataResult adminLogin(String username, String password) {
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

    /**
     * @Description 查询密码以及用户信息
     * @Param username, pagenum, pagesize
     * @return
     **/
    @Override
    public DataResult findAdminAndPwd(Integer id) {
        Admin admin = new Admin();
        admin.setId(id);
        return DataResult.ok(adminMapper.findAdminAndLogin(admin));
    }
    
    /**
     * @Description 查询用户列表
     * @Param username, pagenum, pagesize
     * @return 
     **/
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

    /**
     * @Description 添加用户
     * @Param admin
     * @return 
     **/
    @Override
    public DataResult insertAdmin(Admin admin) {
        adminMapper.insertAdmin(admin);
        return DataResult.ok();
    }

    /**
     * @Description 修改信息
     * @Param admin，id
     * @return
     **/
    @Override
    public DataResult updetaAdmin(Integer id, Admin admin) {
        admin.setId(id);
        adminMapper.updataAdmin(admin);
        return DataResult.ok();
    }

    /**
     * @Description 修改用户状态
     * @Param id, status
     * @return
     **/
    @Override
    public DataResult updataAdminStatus(Integer id, Integer status) {
        Admin admin=new Admin();
        admin.setId(id);
        admin.setStatus(status);
        adminMapper.updataAdminStatus(admin);
        return DataResult.ok();
    }

    /**
     * @Description 删除管理员
     * @Param  id
     * @return
     **/
    @Override
    public DataResult daleteAdmin(Integer id) {
        adminMapper.daleteAdmin(id);
        return DataResult.ok();
    }

    /**
     * @Description 根据token获取用户信息
     * @Param token
     * @return
     **/
    @Override
    public Admin findAdminByToken(String token) {
        String v = redisService.getV(token);
        Admin admin=null;
        try {
             admin= JsonUtils.jsonToPojo(v, Admin.class);
        }catch (Exception e){
            return admin;
        }

        return admin;
    }

    /**
     * @Description 获取token
     * @Param admin
     * @return
     **/
    private Map<String,Object> getToken(Admin admins){
        String token = UUID.randomUUID().toString();
        redisService.setV(token, JsonUtils.objectToJson(admins));
        Map<String,Object> reslt=new HashMap<>();
        reslt.put("token",token);
        return reslt;
    }
}
