package com.nice.web.service;

import com.nice.web.utils.DataResult;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-08 13:53
 *
 * @author wmj
 * @version 1.0
 */
public interface ReportsService {

    //根据月份查询预约数据报表
    DataResult findReportsByMonth(String month);
}
