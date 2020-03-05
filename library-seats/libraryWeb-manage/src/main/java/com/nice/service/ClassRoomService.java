package com.nice.service;


import com.nice.utils.DataResult;

import java.util.List;
import java.util.Map;

/**

 */
public interface ClassRoomService {
    //查询今天的教室信息
    public List<Map<String,Object>> findTodayClassRoom();
    //查询明天的教室信息
    public List<Map<String,Object>> findTomorrowClassRoom();
    //查询教室的信息
    public DataResult findClassRoom();
    //删除教室的信息
     DataResult delClassRoom(int id);


}
