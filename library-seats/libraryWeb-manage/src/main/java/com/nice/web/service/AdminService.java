package com.nice.web.service;

import com.nice.web.pojo.Admin;
import com.nice.web.utils.DataResult;

/**
 * @ClassName AdminService
 * @Description: TODO
 * @Author wmj
 * @Date 2020/3/1
 * @Version V1.0
 **/
public interface AdminService {
    /*后台登陆*/
    DataResult adminLogin(String username, String password);

    /*密码查询*/
    DataResult findAdminAndPwd(Integer id);

    /*用户列表*/
    DataResult adminList(String username,Integer pagenum,Integer pagesize);

    /*添加用户*/
    DataResult insertAdmin(Admin admin);

    /*修改用户信息*/
    DataResult updetaAdmin(Integer id,Admin admin);

    /*修改用户状态*/
    DataResult updataAdminStatus(Integer id,Integer status);

    //删除用户
    DataResult daleteAdmin(Integer id);

    //根据token获取用户信息
    Admin findAdminByToken(String token);
}
