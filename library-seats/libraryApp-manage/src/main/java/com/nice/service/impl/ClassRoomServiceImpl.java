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

    /**
     * @Description 查询明天的教室信息
     * @param
     * @return com.nice.utils.DataResult
     **/
    @Override
    public DataResult findTomorrowClassRoom() {

        return DataResult.ok(classRoomMapper.findAllClassRoom(null, DateUtil.TomorrowCreateTime(), DateUtil.TomorrowEndTime()));
    }

    /**
     * @Description 查询今天的教室 信息
     * @param
     * @return com.nice.utils.DataResult
     **/
    @Override
    public DataResult findTodayClassRoom() {
        return DataResult.ok(classRoomMapper.findAllClassRoom(null, DateUtil.nowCreateTime(), DateUtil.nowEndTime()));
    }

    @Override
    public DataResult findClassRoom() {
        List<String> classRoom = classRoomMapper.findClassRoom();
        return DataResult.ok(classRoom);
    }

}
