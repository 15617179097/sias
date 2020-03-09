package com.nice.web.controller;

import com.nice.web.service.ReportsService;
import com.nice.web.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Company: 数据报表 <br>
 * Description:  <br>
 * Date: 2020-03-08 13:52
 *
 * @author wmj
 * @version 1.0
 */
@RestController
public class ReportsController {

    @Autowired
    private ReportsService reportsService;

    /*根据月份查数据报表*/
    @GetMapping("reports")
    public DataResult findReportsByMonth(String month){
        return reportsService.findReportsByMonth(month);
    }

}
