package com.nice.web.service;


import com.nice.web.pojo.Classroom;
import com.nice.web.utils.DataResult;

import java.util.List;
import java.util.Map;

/**

 */
public interface ClassRoomService {
    //查询所有教室
    DataResult findAllClassRoom();
    //查询今天的教室信息
    public List<Map<String,Object>> findTodayClassRoom();
    //查询明天的教室信息
    public List<Map<String,Object>> findTomorrowClassRoom();
    //查询教室的信息
    public DataResult findClassRoom();
    //删除教室的信息
     DataResult delete(Integer id);
     //增加教室
     DataResult insertClassroom(Classroom classroom);
    //分页查询教室列表
    DataResult classroomList(String classroomName,Integer pagenum,Integer pagesize);
    //修改教室状态
    DataResult updateClassRoomState(Integer id,Integer state);
    //修该教室信息 教室名称 教室层数
    DataResult updateClassRoom(Integer id,Classroom classroom);

}
