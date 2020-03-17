package com.nice.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.web.mapper.SeatsMapper;
import com.nice.web.pojo.Classroom;
import com.nice.web.pojo.Seats;
import com.nice.web.utils.DataResult;
import com.nice.web.utils.DateUtil;
import com.nice.web.mapper.ClassRoomMapper;
import com.nice.web.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    private ClassRoomMapper classRoomMapper;

    @Autowired
    private SeatsMapper seatsMapper;

    /**
     * @Description 获取明天教室列表
     * @Param
     * @return
     **/
    @Override
    public List<Map<String, Object>> findTomorrowClassRoom() {

        return classRoomMapper.findAllClassRoom(null, DateUtil.TomorrowCreateTime(), DateUtil.TomorrowEndTime());
    }

    /**
     * @Description 获取所以教室列表
     * @Param
     * @return
     **/
    @Override
    public DataResult findAllClassRoom() {
        return DataResult.ok(classRoomMapper.findClassRoomById(null));
    }

    /**
     * @Description 获取明天教室列表
     * @Param
     * @return
     **/
    @Override
    public List<Map<String, Object>> findTodayClassRoom() {
        return classRoomMapper.findAllClassRoom(null, DateUtil.nowCreateTime(), DateUtil.nowEndTime());
    }

    @Override
    public DataResult findClassRoom() {
        List<String> classRoom = classRoomMapper.findClassRoom();
        return DataResult.ok(classRoom);
    }

    /**
     * 根据id删除教室
     * @param id
     * @return
     */
    @Override
    public DataResult delete(Integer id) {
        try {
            classRoomMapper.delete(id);
            seatsMapper.deleteSeates(id);
        } catch (Exception e) {
            return DataResult.fail(500, "删除失败！！", e);
        }
        return DataResult.ok(id);
    }

    /**
     * 添加教室
     * @param classroom
     * @return
     */
    @Override
    public DataResult insertClassroom(Classroom classroom) {
        try {
            classRoomMapper.insertClassroom(classroom);
            for (int i=1;i<classroom.getClassroomNumber();i++){
                Seats seats=new Seats();
                seats.setClassroomId(classroom.getId());
                seats.setSeatMunber(i);
                seatsMapper.insertSeats(seats);
            }

        } catch (Exception e) {
            return DataResult.fail(500, "添加失败！！", e);
        }
        return DataResult.ok(classroom);
    }
    /**
     * @Description 分页查询教室列表
     * @Param username, pagenum, pagesize
     * @return
     **/
    @Override
    public DataResult classroomList(String classroomName,Integer pagenum,Integer pagesize) {
        //分页插件
        PageHelper.startPage(pagenum,pagesize);
        Classroom classrooms=new Classroom();
        classrooms.setClassroomName(classroomName);
        List<Classroom> classroom = classRoomMapper.selectAllClassRoom(classrooms);
        PageInfo<Classroom> classroomList = new PageInfo<Classroom>(classroom);
        Map<String, Object> map =new HashMap<>();
        map.put("classroomList",classroomList.getList());
        map.put("total",classroomList.getTotal());
        return DataResult.ok(map);
    }


}
