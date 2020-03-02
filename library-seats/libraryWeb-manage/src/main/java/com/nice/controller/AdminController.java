package com.nice.controller;

import com.nice.pojo.Admin;
import com.nice.service.AdminService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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
    @RequestMapping("admins")
    public DataResult findAdmin(String query,Integer pagenum,Integer pagesize){
        return adminService.adminList(query,pagenum,pagesize);
    }

    /*查询用户主要信息*/
    @GetMapping("admins/{id}")
    public DataResult findAdminAnd(@PathVariable("id") Integer id){
        return adminService.findAdminAndPwd(id);
    }

    /*添加*/
    @PostMapping("admins")
    public DataResult addAdmin(Admin admin){

        return adminService.insertAdmin(admin);
    }

    /*修改用户信息*/
    @PostMapping("admins/{id}")
    public DataResult updataAdmin(@PathVariable("id")Integer id ,Admin admin){
        return adminService.updetaAdmin(id,admin);
    }

    /*修改用户状态*/
    @PutMapping("admins/{id}/status/{status}")
    public DataResult updataAdminStatus(@PathVariable("id")Integer id,@PathVariable("status")Integer status){
        return adminService.updataAdminStatus(id, status);
    }

    /*删除用户*/
    @DeleteMapping("admins/{id}")
    public DataResult deleteAdmin(@PathVariable("id")Integer id){
        return adminService.daleteAdmin(id);
    }


}
