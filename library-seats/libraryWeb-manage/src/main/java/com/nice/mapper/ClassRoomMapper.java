package com.nice.mapper;

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

    //删除教室
    public void delClassRoom(int id);
}
