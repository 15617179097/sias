package com.nice.service.impl;

import com.nice.mapper.SubscribeMapper;
import com.nice.service.ReportsService;
import com.nice.utils.DataResult;
import com.nice.utils.Reports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-08 13:53
 *
 * @author wmj
 * @version 1.0
 */
@Service
public class ReportsServiceImpl implements ReportsService {
    @Autowired
    private SubscribeMapper subscribeMapper;


    /*根据月份查询数据报表*/
    @Override
    public DataResult findReportsByMonth(String month) {
        List<Map<String, Object>> monthSubscribe = subscribeMapper.findMonthSubscribe(month);
        List<Object> xAxisList = new ArrayList<>();
        List<Object> seriesList = new ArrayList<>();
        for (Map<String,Object> map:monthSubscribe){
            xAxisList.add(map.get("date"));
            seriesList.add(map.get("count"));
        }
        Reports reports = new Reports();
        Map<String, Object> ss = reports.ss(xAxisList, seriesList);
       /* Map<String,Object> xAxis = new HashMap<>();
        xAxis.put("data",xAxisList);

        Map<String,Object> series = new HashMap<>();
        series.put("name","数量");
        series.put("type","line");
        series.put("data",seriesList);
        Map<String,Object> map = new HashMap<>();
        map.put("title",new HashMap<>().put("text","月预约数据"));
        map.put("tooltip",new HashMap<>());
        map.put("yAxis",new HashMap<>());
        map.put("legend",new HashMap<>().put("data",new ArrayList<>().add("数量")));
        *//*map.put("axisLabel",new HashMap<>().put("interval",0));
        map.put("axisLabel",new HashMap<>().put("rotate",40));*//*

        map.put("series",series);
        map.put("xAxis",xAxis);*/
        return DataResult.ok(ss);
    }
}
