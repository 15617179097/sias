package com.nice.mapper;

import com.nice.pojo.Admin;
import com.nice.pojo.Classroom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
@Mapper
public interface ClassRoomMapper {
    public List<Map<String,Object>> findAllClassRoom(@Param("classroomId") Integer classroomId, @Param("createTime") String createTime, @Param("endTime") String endTime);
    public List<String> findClassRoom();

    /**
     * 删除教室信息
     */
    int delete(int id);

    //增加教室
    public int insertClassroom(Classroom classroom);

}
