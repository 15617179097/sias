package com.nice.service;

import com.nice.pojo.Admin;
import com.nice.utils.DataResult;

/**
 * @ClassName AdminService
 * @Description: TODO
 * @Author wmj
 * @Date 2020/3/1
 * @Version V1.0
 **/
public interface AdminService {
    /*后台登陆*/
    DataResult adminLogin(String username,String password);

    /*用户列表*/
    DataResult adminList();
}
