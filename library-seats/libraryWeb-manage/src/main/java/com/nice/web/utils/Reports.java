package com.nice.web.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company: 数据报表返回值 <br>
 * Description:  <br>
 * Date: 2020-03-08 15:50
 *
 * @author wmj
 * @version 1.0
 */
public class Reports {
    //标题
    private final Map<String,Object> title=new HashMap<>();
    //鼠标显示数据
    private final Map<String,Object> tooltip=new HashMap<>();
    //数据描述
    private final Map<String,Object> legend=new HashMap<>();
    //x轴数据
    private final Map<String,Object> xAxis=new HashMap<>();
    //x轴内属性设置title斜字 让内容全部显示
    private final Map<String,Object> axisLabel=new HashMap<>();
    private final Map<String,Object> yAxis=new HashMap<>();
    //展示数据列表
    private final List<Object> series =new ArrayList<>();

    public Map<String,Object> ss(List<String> legendList,List<Object> xList,List<Object> seriesList){
        axisLabel.put("interval",0);
        axisLabel.put("rotate",40);
        title.put("text","当月预约数据");
        List<Object> list=new ArrayList<>();
        list.add("预约数量");
        list.add("未签到数量");
        list.add("完成数量");
        legend.put("data",list);
        xAxis.put("axisLabel",axisLabel);
        xAxis.put("data",xList);

        //数据内容
        Map<String,Object> seriesItem=new HashMap<>();
        seriesItem.put("name","数量");
        seriesItem.put("type","line");
        seriesItem.put("data",seriesList);

        //echarts option数据
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("title",title);
        resMap.put("tooltip",tooltip);
        resMap.put("legend",legend);
        resMap.put("xAxis",xAxis);
        resMap.put("yAxis",yAxis);
        series.add(seriesItem);
        resMap.put("series",series);
        return  resMap;
    }
}
