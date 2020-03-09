package com.nice.web.controller;

import com.nice.web.service.ModularService;
import com.nice.web.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ModularController 左侧菜单
 * @Description: TODO
 * @Author wmj
 * @Date 2020/3/1
 * @Version V1.0
 **/

@RestController
public class ModularController {

    @Autowired
    private ModularService modularService;


    /**
     * @Description 获取菜单列表
     * @param
     * @return com.nice.web.utils.DataResult
     **/
    @GetMapping("/modular")
    public DataResult findModularList(){
        return modularService.findModular();
    }


}
