package com.nice.web.controller;

import com.nice.web.pojo.Admin;
import com.nice.web.service.AdminService;
import com.nice.web.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName AdminController   管理员
 * @Description: TODO
 * @Author wmj
 * @Date 2020/3/1
 * @Version V1.0
 **/

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * @Description 登陆
     * @param username
     * @param password
     * @return com.nice.web.utils.DataResult
     **/
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public DataResult loginAdmin(String username, String password){
        return  adminService.adminLogin(username,password);
    }

    /**
     * @Description 获取用户列表
     * @param query
     * @param pagenum
     * @param pagesize
     * @return com.nice.web.utils.DataResult
     **/
    @RequestMapping("admins")
    public DataResult findAdmin(String query,Integer pagenum,Integer pagesize){
        return adminService.adminList(query,pagenum,pagesize);
    }

    /**
     * @Description 查询用户主要信息
     * @param id
     * @return com.nice.web.utils.DataResult
     **/
    @GetMapping("admins/{id}")
    public DataResult findAdminAnd(@PathVariable("id") Integer id){
        return adminService.findAdminAndPwd(id);
    }

    /**
     * @Description 添加管理员
     * @param admin
     * @return com.nice.web.utils.DataResult
     **/
    @PostMapping("admins")
    public DataResult addAdmin(Admin admin){

        return adminService.insertAdmin(admin);
    }

    /**
     * @Description 修改用户信息
     * @param id
     * @param admin
     * @return com.nice.web.utils.DataResult
     **/
    @PostMapping("admins/{id}")
    public DataResult updataAdmin(@PathVariable("id")Integer id,Admin admin){
        return adminService.updetaAdmin(id,admin);
    }

    /**
     * @Description 修改用户状态
     * @param id
     * @param status
     * @return com.nice.web.utils.DataResult
     **/
    @PutMapping("admins/{id}/status/{status}")
    public DataResult updataAdminStatus(@PathVariable("id")Integer id,@PathVariable("status")Integer status){
        return adminService.updataAdminStatus(id, status);
    }

    /**
     * @Description
     * @param id
     * @return com.nice.web.utils.DataResult
     **/
    @DeleteMapping("admins/{id}")
    public DataResult deleteAdmin(@PathVariable("id")Integer id){
        return adminService.daleteAdmin(id);
    }


}
