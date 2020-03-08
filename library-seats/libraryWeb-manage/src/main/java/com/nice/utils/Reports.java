package com.nice.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-08 15:50
 *
 * @author wmj
 * @version 1.0
 */
public class Reports {
    //标题
    private final Map<String,Object> title=new HashMap<>();

    private final Map<String,Object> tooltip=new HashMap<>();
    private final Map<String,Object> legend=new HashMap<>();
    private final Map<String,Object> xAxis=new HashMap<>();
    private final Map<String,Object> axisLabel=new HashMap<>();
    private final Map<String,Object> yAxis=new HashMap<>();
    private final Map<String,Object> seriesItem=new HashMap<>();

    public Map<String,Object> ss(List<Object> xList,List<Object> seriesList){
        axisLabel.put("interval",0);
        axisLabel.put("rotate",40);
        title.put("text","当月预约数据");
        List<Object> list=new ArrayList<>();
        list.add("数量");
        legend.put("data",list);
        xAxis.put("axisLabel",axisLabel);
        xAxis.put("data",xList);
        seriesItem.put("name","数量");
        seriesItem.put("type","line");
        seriesItem.put("data",seriesList);
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("title",title);
        resMap.put("tooltip",tooltip);
        resMap.put("legend",legend);
        resMap.put("xAxis",xAxis);
        resMap.put("yAxis",yAxis);
        List<Object> series =new ArrayList<>();
        series.add(seriesItem);
        resMap.put("series",series);
        return  resMap;
    }
}
