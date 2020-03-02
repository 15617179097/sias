package com.nice.controller;

import com.nice.service.ModularService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ModularController
 * @Description: TODO
 * @Author wmj
 * @Date 2020/3/1
 * @Version V1.0
 **/

/*
* 左侧菜单
* */
@RestController
public class ModularController {

    @Autowired
    private ModularService modularService;
    /*
    * 获取菜单列表
    */
    @RequestMapping("/modular")
    public DataResult findModularList(){
        return modularService.findModular();
    }
}
