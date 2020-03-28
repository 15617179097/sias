package com.nice.web.controller;

import com.nice.web.service.SupervisionService;
import com.nice.web.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-28 21:31
 *
 * @author wmj
 * @version 1.0
 */
@RestController
public class SupervisionController {

    @Autowired
    private SupervisionService supervisionService;
    /**
     * @Description 获取监督占位列表
     * @param pagenum
     * @param pagesize
     * @param query
     * @return com.nice.web.utils.DataResult
     **/
    @GetMapping("supervision")
    public DataResult findSupervision(
            @RequestParam(value = "pagenum",defaultValue = "1")int pagenum,
            @RequestParam(value = "pagesize", defaultValue = "10")int pagesize,
            String query){
        return supervisionService.findSupervision(query,pagenum,pagesize);
    }

    /**
     * @Description 完成监督占位工作
     * @param id
     * @return com.nice.web.utils.DataResult
     **/
    @PutMapping("supervision/{id}")
    public DataResult findSupervision(@PathVariable("id")int id){
        return supervisionService.updateSupervision(id);
    }
}
