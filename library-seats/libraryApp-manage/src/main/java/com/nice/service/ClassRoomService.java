package com.nice.service;


import com.nice.utils.DataResult;

import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-13 15:13
 *
 * @author wmj
 * @version 1.0
 */
public interface ClassRoomService {

    //查询今天的教室信息
    public List<Map<String,Object>> findTodayClassRoom();

    //查询明天的教室信息
    public List<Map<String,Object>> findTomorrowClassRoom();

    //查询教室的信息
    public DataResult findClassRoom();
}
