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
 *
 */
@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    private ClassRoomMapper classRoomMapper;

    @Override
    public List<Map<String,Object>> findTomorrowClassRoom() {

        return classRoomMapper.findAllClassRoom(null, DateUtil.TomorrowCreateTime(), DateUtil.TomorrowEndTime());
    }

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