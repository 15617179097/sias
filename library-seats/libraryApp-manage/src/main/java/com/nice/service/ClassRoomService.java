package com.nice.service;


import com.nice.utils.DataResult;
import org.springframework.web.bind.annotation.RequestParam;

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
    public DataResult findTodayClassRoom(Integer pagenum,Integer pagesize);

    //查询明天的教室信息
    public DataResult findTomorrowClassRoom(Integer pagenum,Integer pagesize);

    //查询教室的信息
    public DataResult findClassRoom();
}
