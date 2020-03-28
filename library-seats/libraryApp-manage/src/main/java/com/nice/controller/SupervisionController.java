package com.nice.controller;

import com.nice.pojo.Supervision;
import com.nice.service.SupervisionService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Company:  监督占座位<br>
 * Description:  <br>
 * Date: 2020-03-28 20:37
 *
 * @author wmj
 * @version 1.0
 */
@RestController
public class SupervisionController {

    @Autowired
    private SupervisionService supervisionService;

    //座位监督
    @PostMapping("supervision")
    public DataResult insertSupervision(Supervision supervision, HttpServletRequest request){
        return supervisionService.insertSupervision(supervision,request);
    }
}
