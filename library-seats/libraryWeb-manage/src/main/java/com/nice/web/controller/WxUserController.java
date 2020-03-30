package com.nice.web.controller;

import com.nice.web.service.WxUserService;
import com.nice.web.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @Description 分页查询用户列表
     * @param query
     * @param pagenum
     * @param pagesize
     * @return com.nice.web.utils.DataResult
     **/
    @GetMapping("users")
    public DataResult findWxUser(Integer query, Integer pagenum, Integer pagesize){
        return wxUserService.findWxUser(query,pagenum,pagesize);
    }

    /**
     * @Description 禁用用户
     * @param id
     * @param state
     * @return com.nice.web.utils.DataResult
     **/
    @PutMapping("users/{id}/state/{state}")
    public DataResult updataWxUserState(@PathVariable("id")Integer id,@PathVariable("state")Integer state){
        return wxUserService.updataWxUserState(id,state);
    }

    /**
     * @Description 删除用户绑定的信息
     * @param id
     * @return com.nice.web.utils.DataResult
     **/
    @DeleteMapping("users/{id}")
    public DataResult updataWxUserState(@PathVariable("id")Integer id,String studentId){
        return wxUserService.deleteUserInfo(id,studentId);
    }

}
