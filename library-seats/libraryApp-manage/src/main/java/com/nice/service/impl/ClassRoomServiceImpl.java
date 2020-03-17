package com.nice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.mapper.ClassRoomMapper;
import com.nice.pojo.Classroom;
import com.nice.service.ClassRoomService;
import com.nice.utils.DataResult;
import com.nice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    public DataResult findTomorrowClassRoom(Integer pagenum,Integer pagesize) {
        PageHelper.startPage(pagenum, pagesize);
        List<Map<String, Object>> allClassRoom = classRoomMapper.findAllClassRoom(null, DateUtil.TomorrowCreateTime(), DateUtil.TomorrowEndTime());
        PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(allClassRoom);
        return DataResult.ok(getResultMap(mapPageInfo));
    }

    /**
     * @Description 查询今天的教室 信息
     * @param
     * @return com.nice.utils.DataResult
     **/
    @Override
    public DataResult findTodayClassRoom(Integer pagenum,Integer pagesize) {
        PageHelper.startPage(pagenum, pagesize);
        List<Map<String, Object>> allClassRoom = classRoomMapper.findAllClassRoom(null, DateUtil.nowCreateTime(), DateUtil.nowEndTime());
        PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(allClassRoom);
        return DataResult.ok(getResultMap(mapPageInfo));
    }
    private Map<String, Object> getResultMap(PageInfo<Map<String, Object>> list){
        List<Classroom> classRoom = classRoomMapper.findClassRoom();
        List<Object> floors=new ArrayList<>();
        for (Classroom map:classRoom){
            if (!floors.contains(map.getFloor())){
                floors.add(map.getFloor());
            }
        }
        Map<String, Object> map= new HashMap<>();
        map.put("classroomList",list.getList());
        map.put("pageTotal",list.getPages());
        map.put("floors",floors);
        return map;
    }

    @Override
    public DataResult findClassRoom() {
        List<Classroom> classRoom = classRoomMapper.findClassRoom();

        return DataResult.ok(classRoom);
    }

}
