package com.nice.controller;

import com.nice.service.WxUserService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * @ClassName WxUserController
 * @Description: TODO
 * @Author wmj
 * @Date 2020/3/3
 * @Version V1.0
 **/
@RestController
public class WxUserController {

    @Autowired
    private WxUserService wxUserService;

    //查询用户列表
    @GetMapping("users")
    public DataResult findWxUser(Integer query,Integer pagenum, Integer pagesize){
        return wxUserService.findWxUser(query,pagenum,pagesize);
    }

    //禁用用户
    @PutMapping("users/{id}/state/{state}")
    public DataResult updataWxUserState(@PathVariable("id")Integer id,@PathVariable("state")Integer state){
        return wxUserService.updataWxUserState(id,state);
    }

    //删除用户绑定的信息
    @DeleteMapping("users/{id}")
    public DataResult updataWxUserState(@PathVariable("id")Integer id){
        return wxUserService.deleteUserInfo(id);
    }

}
