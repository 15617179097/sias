package com.nice.service.impl;

import com.nice.mapper.ClassRoomMapper;
import com.nice.service.ClassRoomService;
import com.nice.utils.DataResult;
import com.nice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-13 15:14
 *
 * @author wmj
 * @version 1.0
 */
@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    private ClassRoomMapper classRoomMapper;

    /* 查询明天的教室 信息  */
    @Override
    public List<Map<String,Object>> findTomorrowClassRoom() {

        return classRoomMapper.findAllClassRoom(null, DateUtil.TomorrowCreateTime(), DateUtil.TomorrowEndTime());
    }

    /*查询今天的教室 信息 */
    @Override
    public List<Map<String, Object>> findTodayClassRoom() {
        return classRoomMapper.findAllClassRoom(null, DateUtil.nowCreateTime(), DateUtil.nowEndTime());
    }

    @Override
    public DataResult findClassRoom() {
        List<String> classRoom = classRoomMapper.findClassRoom();
        return DataResult.ok(classRoom);
    }

}
