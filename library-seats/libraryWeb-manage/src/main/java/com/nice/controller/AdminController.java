package com.nice.controller;

import com.nice.pojo.Admin;
import com.nice.service.AdminService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName AdminController
 * @Description: TODO
 * @Author wmj
 * @Date 2020/3/1
 * @Version V1.0
 **/
/*
*  管理员
*/
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdminController {

    @Autowired
    private AdminService adminService;

    /*登陆*/
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public DataResult loginAdmin(String username,String password){
        return  adminService.adminLogin(username,password);
    }

    /*获取用户列表*/
    @RequestMapping("users")
    public DataResult findUsers(){
        return adminService.adminList();
    }

    /*添加*/
    @PostMapping("addAdmin")
    public DataResult addAdmin(){

        return null;
    }
}
