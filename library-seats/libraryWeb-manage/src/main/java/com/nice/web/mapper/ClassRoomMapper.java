package com.nice.web.mapper;

import com.nice.web.pojo.Classroom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-13 12:30
 *
 * @author wmj
 * @version 1.0
 */
@Component
@Mapper
public interface ClassRoomMapper {
    //获取所有教室
    public List<Map<String,Object>> findAllClassRoom(@Param("classroomId") Integer classroomId, @Param("createTime") String createTime, @Param("endTime") String endTime);
    public List<String> findClassRoom();
    //根据教室id查询
    List<Classroom> findClassRoomById(@Param("id")Integer id);
    //删除教室
    public void delete(Integer id);
    //添加教室
    public int insertClassroom(Classroom classroom);
    //分页查询所有教室
    public List<Classroom> selectAllClassRoom(Classroom classroom);
    //修改教室状态 0&1
    public int updateClassRoomState(Classroom classroom);
}
