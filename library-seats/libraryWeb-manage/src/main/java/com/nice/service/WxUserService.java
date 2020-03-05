package com.nice.service;

import com.nice.utils.DataResult;

import java.util.List;
import java.util.Map;

/**
 * @ClassName WxUserService
 * @Description: TODO
 * @Author wmj
 * @Date 2020/3/4
 * @Version V1.0
 **/
public interface WxUserService {

    //查询微信用户列表
    DataResult findWxUser(Integer studentId,Integer pagenum,Integer pagesize);

    //禁止用户使用
    DataResult updataWxUserState(Integer id,Integer state);

    //删除绑定学号等信息
    DataResult deleteUserInfo(Integer id);
}
