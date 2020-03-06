package com.nice.service.impl;

import com.nice.mapper.ClassRoomMapper;
import com.nice.pojo.Classroom;
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
    public List<Map<String, Object>> findTomorrowClassRoom() {

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

    @Override
    public DataResult delete(Integer id) {
        try {
            classRoomMapper.delete(id);
        }catch (Exception e){
            return DataResult.fail(500,"删除失败！",e);
        }
        return DataResult.ok();
}
//增加教室
    @Override
    public DataResult insertClassroom(Classroom classroom) {
        try {
            classRoomMapper.insertClassroom(classroom);
        }catch (Exception e){
            return  DataResult.fail(500,"添加失败",e);
        }
        return DataResult.ok();
    }


}
